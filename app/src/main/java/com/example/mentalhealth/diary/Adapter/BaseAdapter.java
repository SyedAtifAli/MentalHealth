package com.example.mentalhealth.diary.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealth.R;
import com.example.mentalhealth.diary.AddActivity;
import com.example.mentalhealth.diary.Holder.BaseHolder;
import com.example.mentalhealth.diary.ItemObject;
import com.example.mentalhealth.diary.SQLiteNote;

import java.util.List;


public class BaseAdapter extends RecyclerView.Adapter<BaseHolder> {

    Context context;
    List<ItemObject> object_list;
    BaseAdapterClickListener clickListener;

    public interface BaseAdapterClickListener {
        void testClick(String waktu);
    }

    public BaseAdapter(Context context, List<ItemObject> object_list) {
        this.context = context;
        this.object_list = object_list;
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_carditem, null);
        BaseHolder holder = new BaseHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {
        holder.txt_waktu.setText(object_list.get(position).waktu);
        holder.txt_judul.setText(object_list.get(position).judul);

        holder.card_item_note.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AddActivity.class);
            intent.putExtra("judul", object_list.get(position).judul);
            intent.putExtra("konten", object_list.get(position).konten);
            view.getContext().startActivity(intent);
        });


        holder.card_item_note.setOnLongClickListener(view -> {
            DialogInterface.OnClickListener dialogClickListener = (dialog, which) -> {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        SQLiteNote db_note = new SQLiteNote(context);
                        db_note.deleteItemSelected(object_list.get(position).waktu);
                        db_note.getData();
                        break;
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("Are you sure to delete ?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
            return true;
        });

        setRandomColor(holder.card_item_note);

    }

    private void setRandomColor(CardView card_item_note) {
        int min = 0;
        int max = 10;

        //Generate random int value from 0 to 10
        System.out.println("Random value in int from "+min+" to "+max+ ":");
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        if(random_int == 0){
            card_item_note.setCardBackgroundColor(Color.parseColor("#d7ccc8"));
        }
        else if(random_int == 2){
            card_item_note.setCardBackgroundColor(Color.parseColor("#ffccbc"));
        }
        else if(random_int == 3){
            card_item_note.setCardBackgroundColor(Color.parseColor("#ffe0b2"));
        }
        else if(random_int == 4){
            card_item_note.setCardBackgroundColor(Color.parseColor("#fff9c4"));
        }
        else if(random_int == 5){
            card_item_note.setCardBackgroundColor(Color.parseColor("#b2ff59"));
        }
        else if(random_int == 6){
            card_item_note.setCardBackgroundColor(Color.parseColor("#69f0ae"));
        }
        else if(random_int == 7){
            card_item_note.setCardBackgroundColor(Color.parseColor("#80d8ff"));
        }
        else if(random_int == 8){
            card_item_note.setCardBackgroundColor(Color.parseColor("#ff8a80"));
        }
        else if(random_int == 9){
            card_item_note.setCardBackgroundColor(Color.parseColor("#ff80ab"));
        }
        else{
            card_item_note.setCardBackgroundColor(Color.parseColor("#ea80fc"));
        }
    }

    @Override
    public int getItemCount() {
        return object_list.size();
    }
}
