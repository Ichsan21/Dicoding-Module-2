package com.rizky92.latihannavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailCategoryFragment extends Fragment {

    public DetailCategoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvCatName = view.findViewById(R.id.tv_cat_name);
        TextView tvCatDesc = view.findViewById(R.id.tv_cat_desc);

        String dataName = DetailCategoryFragmentArgs.fromBundle(getArguments()).getName();
        int dataValue = DetailCategoryFragmentArgs.fromBundle(getArguments()).getStock();

        tvCatName.setText(dataName);
        tvCatDesc.setText("Stock saat ini : " + dataValue);

        Button btnReturn = view.findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment, null));
    }

}
