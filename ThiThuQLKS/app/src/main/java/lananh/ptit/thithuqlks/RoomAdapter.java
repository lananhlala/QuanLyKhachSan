package lananh.ptit.thithuqlks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import lananh.ptit.thithuqlks.admin.AdminHomeActivity;
import lananh.ptit.thithuqlks.admin.ListPhongActivity;
import lananh.ptit.thithuqlks.admin.SuaPhongActivity;
import lananh.ptit.thithuqlks.client.ChiTietPhongActivity;
import lananh.ptit.thithuqlks.client.ClientHomeActivity;

public class RoomAdapter extends BaseAdapter {
    private Context context;
    private  int layout;
    private List<Room> listRoom;

    public RoomAdapter(Context context, int layout, List<Room> listRoom) {
        this.context = context;
        this.layout = layout;
        this.listRoom = listRoom;
    }

    public RoomAdapter() {
    }

    @Override
    public int getCount() {
        return listRoom.size();
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
        convertView = inflater.inflate(layout, null);
        final TextView tvSoP = convertView.findViewById(R.id.tvSoP);
        TextView tvLoaiP = convertView.findViewById(R.id.tvLoaiP);
        TextView tvTrangthai = convertView.findViewById(R.id.tvTrangthai);
        final Room r = listRoom.get(position);
        tvLoaiP.setText(r.getLoaiP());
        tvSoP.setText(Integer.toString(r.getSoP()));
        tvTrangthai.setText(r.getTrangthai());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context.getClass()== ClientHomeActivity.class){
                    Intent intent = new Intent(context, ChiTietPhongActivity.class);
                    intent.putExtra("soP", Integer.toString(r.getSoP()));
                    context.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(context, SuaPhongActivity.class);
                    intent.putExtra("soP", Integer.toString(r.getSoP()));
                    context.startActivity(intent);
                }
            }
        });
        return convertView;
    }
}
