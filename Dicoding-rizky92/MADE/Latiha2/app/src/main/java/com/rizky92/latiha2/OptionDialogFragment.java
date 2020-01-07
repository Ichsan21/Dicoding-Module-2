package com.rizky92.latiha2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Dialog Fragment
 */

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {
    Button btnChoose, btnClose;
    RadioGroup rgAns;
    RadioButton rbAnsYes, rbAnsNo, rbAnsMaybe, rbAnsRand;
    OnOptionDialogListener optionDialogListener;


    public OptionDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);

        rgAns = view.findViewById(R.id.rg_options);
        rbAnsYes = view.findViewById(R.id.ans_1);
        rbAnsNo = view.findViewById(R.id.ans_2);
        rbAnsMaybe = view.findViewById(R.id.ans_3);
        rbAnsRand = view.findViewById(R.id.ans_4);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment fragment = getParentFragment();

        if (fragment instanceof DetailCategoryFragment) {
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_close:
                getDialog().cancel();
                break;

            case R.id.btn_choose:
                int checked = rgAns.getCheckedRadioButtonId();

                if (checked != -1) {
                    String ans = null;
                    switch (checked) {
                        case R.id.ans_1:
                            ans = rbAnsYes.getText().toString().trim();
                            break;

                        case R.id.ans_2:
                            ans = rbAnsNo.getText().toString().trim();
                            break;

                        case R.id.ans_3:
                            ans = rbAnsMaybe.getText().toString().trim();
                            break;

                        case R.id.ans_4:
                            ans = rbAnsRand.getText().toString().trim();
                            break;
                    }

                    if (optionDialogListener != null) {
                        optionDialogListener.onOptionChosen(ans);
                    }
                    getDialog().dismiss();
                }
                break;
        }
    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }
}
