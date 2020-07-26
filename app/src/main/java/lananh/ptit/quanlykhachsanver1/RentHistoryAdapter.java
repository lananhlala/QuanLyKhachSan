package lananh.ptit.quanlykhachsanver1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RentHistoryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<RentHistory> listRent;

    public RentHistoryAdapter(Context context, int layout, List<RentHistory> listRent) {
        this.context = context;
        this.layout = layout;
        this.listRent = listRent;
    }

    @Override
    public int getCount() {
        return listRent.size();
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
        TextView tvGiaP = convertView.findViewById(R.id.tvGia);
        TextView tvGioVao = convertView.findViewById(R.id.tvGioVao);
        TextView tvGioRa = convertView.findViewById(R.id.tvGioRa);
        TextView tvTotal = convertView.findViewById(R.id.tvTotal);

        // gan gia tri
        final RentHistory r = listRent.get(position);
        tvSoP.setText("Phòng " + Integer.toString(r.getSoP()));
        tvGiaP.setText("Giá " + Float.toString(r.getGiaP()));
        tvGioVao.setText("Giờ vào " + r.getGioVao());
        tvGioRa.setText("Giờ ra " + r.getGioRa());
        tvTotal.setText("Thành tiền " + Integer.toString(r.getThanhTien()));
        return convertView;
    }
}
