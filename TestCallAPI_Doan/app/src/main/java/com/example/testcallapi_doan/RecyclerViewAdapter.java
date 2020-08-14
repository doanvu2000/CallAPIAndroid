package com.example.testcallapi_doan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<VideoObject> videoObjectList;

    public RecyclerViewAdapter(List<VideoObject> videoObjectList) {
        this.videoObjectList = videoObjectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.item_layout, parent, false );
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        {
            holder.tv1.setText( String.valueOf( videoObjectList.get( position ).getId() ) );
            holder.tv2.setText( String.valueOf( videoObjectList.get( position ).getPublisher_id() ) );
            holder.tv3.setText( String.valueOf( videoObjectList.get( position ).getContent_type() ) );
            holder.tv4.setText( String.valueOf( videoObjectList.get( position ).getTab() ) );
            holder.tv5.setText( videoObjectList.get( position ).getTitle() );
            holder.tv6.setText( videoObjectList.get( position ).getAvatar() );
            holder.tv7.setText( String.valueOf( videoObjectList.get( position ).getStatus() ) );
            holder.tv8.setText( String.valueOf( videoObjectList.get( position ).getDeleted() ) );
            holder.tv9.setText( String.valueOf( videoObjectList.get( position ).getUser_created() ) );
            holder.tv10.setText( String.valueOf( videoObjectList.get( position ).getUser_modified() ) );
            holder.tv11.setText( videoObjectList.get( position ).getDate_created() );
            holder.tv12.setText( videoObjectList.get( position ).getDate_modified() );
            holder.tv13.setText( String.valueOf( videoObjectList.get( position ).getParent_id() ) );
            holder.tv14.setText( String.valueOf( videoObjectList.get( position ).getLft() ) );
            holder.tv15.setText( String.valueOf( videoObjectList.get( position ).getRgt() ) );
            holder.tv16.setText( String.valueOf( videoObjectList.get( position ).getLevel() ) );
            holder.tv17.setText( videoObjectList.get( position ).getShort_code() );
            holder.tv18.setText( videoObjectList.get( position ).getCommand_code() );
            holder.tv19.setText( String.valueOf( videoObjectList.get( position ).getPrice() ) );
            holder.tv20.setText( videoObjectList.get( position ).getFinished_message() );
            holder.tv21.setText( videoObjectList.get( position ).getHelp_message() );
            holder.tv22.setText( String.valueOf( videoObjectList.get( position ).getIcash() ) );
            holder.tv23.setText( videoObjectList.get( position ).getThumb() );
        }
    }

    @Override
    public int getItemCount() {
        return videoObjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4, tv5, tv6;
        TextView tv7, tv8, tv9, tv10, tv11, tv12;
        TextView tv13, tv14, tv15, tv16, tv17, tv18;
        TextView tv19, tv20, tv21, tv22, tv23;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            {
                tv1 = itemView.findViewById( R.id.tv1 );
                tv2 = itemView.findViewById( R.id.tv2 );
                tv3 = itemView.findViewById( R.id.tv3 );
                tv4 = itemView.findViewById( R.id.tv4 );
                tv5 = itemView.findViewById( R.id.tv5 );
                tv6 = itemView.findViewById( R.id.tv6 );
                tv7 = itemView.findViewById( R.id.tv7 );
                tv8 = itemView.findViewById( R.id.tv8 );
                tv9 = itemView.findViewById( R.id.tv9 );
                tv10 = itemView.findViewById( R.id.tv10 );
                tv11 = itemView.findViewById( R.id.tv11 );
                tv12 = itemView.findViewById( R.id.tv12 );
                tv13 = itemView.findViewById( R.id.tv13 );
                tv14 = itemView.findViewById( R.id.tv14 );
                tv15 = itemView.findViewById( R.id.tv15 );
                tv16 = itemView.findViewById( R.id.tv16 );
                tv17 = itemView.findViewById( R.id.tv17 );
                tv18 = itemView.findViewById( R.id.tv18 );
                tv19 = itemView.findViewById( R.id.tv19 );
                tv20 = itemView.findViewById( R.id.tv20 );
                tv21 = itemView.findViewById( R.id.tv21 );
                tv22 = itemView.findViewById( R.id.tv22 );
                tv23 = itemView.findViewById( R.id.tv23 );
            }
        }
    }
}
