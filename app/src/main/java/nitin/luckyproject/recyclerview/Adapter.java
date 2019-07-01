package nitin.luckyproject.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<String> values;

    public Adapter(List<String> myDataset) {
        values = myDataset;
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }
    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v =inflater.inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(v);
    }
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.textone.setText(values.get(position));
        holder.textone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(position);
            }
        });

        holder.texttwo.setText("Footer: " + values.get(position));
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textone;
        TextView texttwo;
        View layout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            layout=itemView;
            textone = itemView.findViewById(R.id.firstLine);
            texttwo =itemView.findViewById(R.id.secondLine);

        }
    }

    }
