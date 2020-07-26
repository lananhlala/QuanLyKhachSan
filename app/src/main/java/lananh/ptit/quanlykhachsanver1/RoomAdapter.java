package lananh.ptit.quanlykhachsanver1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import lananh.ptit.quanlykhachsanver1.admin.ChiTietPhongActivity;
import lananh.ptit.quanlykhachsanver1.admin.QuanLyPhongActivity;
import lananh.ptit.quanlykhachsanver1.client.TrangThaiPhongActivity;

public class RoomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Room> listRooms;

    public RoomAdapter(Context context, int layout, List<Room> listRooms) {
        this.context = context;
        this.layout = layout;
        this.listRooms = listRooms;
    }

    @Override
    public int getCount() {
        return listRooms.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout,null);
        TextView tvSoP = convertView.findViewById(R.id.tvSoP);
        TextView tvLoaiP = convertView.findViewById(R.id.tvLoaiP);
        TextView tvStatus = convertView.findViewById(R.id.tvStatus);

        // gan gia tri
        final Room r = listRooms.get(position);
        tvSoP.setText(Integer.toString(r.getSoP()));
        tvLoaiP.setText(r.getLoaiP());
        tvStatus.setText(r.getTrangthaiP());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context.getClass()==QuanLyPhongActivity.class){
                    Intent intent = new Intent(context, ChiTietPhongActivity.class);
                    intent.putExtra("soP", Integer.toString(r.getSoP()));
                    context.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(context, TrangThaiPhongActivity.class);
                    intent.putExtra("soP", Integer.toString(r.getSoP()));
                    context.startActivity(intent);
                }
            }
        });
        return convertView;
    }
}
