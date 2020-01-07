package com.rizky92.latihanfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCategoryFragment extends Fragment implements View.OnClickListener{
    TextView tvCatName, tvCatDetail;
    Button btnProfile, btnDialog;

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";
    private String desc;

    public String getDesc() { return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public DetailCategoryFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvCatName = view.findViewById(R.id.tv_cat_name);
        tvCatDetail = view.findViewById(R.id.tv_cat_detail);

        btnProfile = view.findViewById(R.id.btn_profile);
        btnDialog = view.findViewById(R.id.btn_show_dialog);

        btnProfile.setOnClickListener(this);
        btnDialog.setOnClickListener(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String catName = getArguments().getString(EXTRA_NAME);
        tvCatName.setText(catName);
        tvCatDetail.setText(getDesc());
    }

    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_profile:
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_show_dialog:
                OptionDialogFragment optionDialogFragment = new OptionDialogFragment();

                FragmentManager fragmentManager = getChildFragmentManager();
                optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }
    }
}
