package tech.rtsproduction.amritsartourguide;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TouristAttFragment extends Fragment {

    Toolbar toolbar;
    ListView listView;

    public TouristAttFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tourist_att,container,false);
        toolbar = rootView.findViewById(R.id.toolbarTourist);
        listView = rootView.findViewById(R.id.listViewTourist);
        toolbar.setTitle(R.string.touristAtt);
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        if (((AppCompatActivity)getActivity()).getSupportActionBar() != null) {
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final ArrayList<Location> touristAttList = new ArrayList<>();
        touristAttList.add(new Location(getString(R.string.attractionName1), getString(R.string.attractionAddress1), R.drawable.golden_temple, getString(R.string.attractionDetail1)));
        touristAttList.add(new Location(getString(R.string.attractionName2), getString(R.string.attractionAddress2), R.drawable.jalliawala, getString(R.string.attractionDetail2)));
        touristAttList.add(new Location(getString(R.string.attractionName3), getString(R.string.attractionAddress3), R.drawable.gobindgarh, getString(R.string.attractionDetail3)));
        touristAttList.add(new Location(getString(R.string.attractionName4), getString(R.string.attractionAddress4), R.drawable.khalsa, getString(R.string.attractionDetail4)));
        touristAttList.add(new Location(getString(R.string.attractionName5), getString(R.string.attractionAddress5), R.drawable.durgiana, getString(R.string.attractionDetail5)));
        touristAttList.add(new Location(getString(R.string.attractionName6), getString(R.string.attractionAddress6), R.drawable.matatemple, getString(R.string.attractionDetail6)));
        touristAttList.add(new Location(getString(R.string.attractionName7), getString(R.string.attractionAddress7), R.drawable.ranjitmuseum, getString(R.string.attractionDetail7)));
        touristAttList.add(new Location(getString(R.string.attractionName8), getString(R.string.attractionAddress8), R.drawable.alphaone, getString(R.string.attractionDetail8)));
        touristAttList.add(new Location(getString(R.string.attractionName9), getString(R.string.attractionAddress9), R.drawable.gndu, getString(R.string.attractionDetail9)));

        LocationAdapter adapter = new LocationAdapter(getActivity(), touristAttList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Location object = touristAttList.get(i);
                showAlert(object);

            }
        });

        return rootView;
    }

    private void showAlert(Location object) {
        AlertDialog.Builder alertAdd = new AlertDialog.Builder(getActivity());
        alertAdd.setTitle(object.getLocationTitle());
        LayoutInflater inflater = LayoutInflater.from(getActivity());

        final View view1 = inflater.inflate(R.layout.activity_detail, null);
        TextView t1 = view1.findViewById(R.id.subtitleTextDetail);
        t1.setText(object.getLocationSubtitle());
        TextView t2 = view1.findViewById(R.id.locationTextDetail);
        t2.setText(object.getLocationAddress());
        ImageView i1 = view1.findViewById(R.id.imageDetail);
        if (object.getLocationPhoto() != -1) {
            i1.setImageResource(object.getLocationPhoto());
        }
        alertAdd.setView(view1);
        alertAdd.setNeutralButton(R.string.done, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertAdd.show();
    }

}
