package lananh.ptit.quanlykhachsanver1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DoanhThuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<DoanhThu> doanhThus;
    public DoanhThuAdapter(Context context, int layout, List<DoanhThu> doanhThus) {
        this.context = context;
        this.layout = layout;
        this.doanhThus = doanhThus;
    }
    @Override
    public int getCount() {
        return doanhThus.size();
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
        TextView tvDoanhthu = convertView.findViewById(R.id.tvDoanhthu);

        // gan gia tri
        final DoanhThu dt = doanhThus.get(position);
        tvSoP.setText("Phòng " + Integer.toString(dt.getSoP()));
        tvDoanhthu.setText("Doanh thu " + Integer.toString(dt.getDoanhthu()));
        return convertView;
    }
}
