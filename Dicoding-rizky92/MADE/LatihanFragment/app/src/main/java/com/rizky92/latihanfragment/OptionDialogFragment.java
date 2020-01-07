package com.rizky92.latihanfragment;

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

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {
    Button btnClose, btnChoose;
    RadioGroup rgOptions;
    RadioButton rbAns1, rbAns2, rbAns3, rbAns4, rbAns5;
    OnOptionDialogListener optionDialogListener;

    public OptionDialogFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);

        rgOptions = view.findViewById(R.id.rg_options);

        rbAns1 = view.findViewById(R.id.rb_ans_1);
        rbAns2 = view.findViewById(R.id.rb_ans_2);
        rbAns3 = view.findViewById(R.id.rb_ans_3);
        rbAns4 = view.findViewById(R.id.rb_ans_4);
        rbAns5 = view.findViewById(R.id.rb_ans_5);

        btnChoose.setOnClickListener(this);
        btnClose.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Fragment frag = getParentFragment();

        if (frag instanceof DetailCategoryFragment) {
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) frag;
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
                int checkRadioButtonId = rgOptions.getCheckedRadioButtonId();

                if (checkRadioButtonId != -1) {
                    String answer = null;
                    switch (checkRadioButtonId) {
                        case R.id.rb_ans_1:
                            answer = rbAns1.getText().toString().trim();
                            break;

                        case R.id.rb_ans_2:
                            answer = rbAns2.getText().toString().trim();
                            break;

                        case R.id.rb_ans_3:
                            answer = rbAns3.getText().toString().trim();
                            break;

                        case R.id.rb_ans_4:
                            answer = rbAns4.getText().toString().trim();
                            break;

                        case R.id.rb_ans_5:
                            answer = rbAns5.getText().toString().trim();
                            break;
                    }

                    if (optionDialogListener != null) {
                        optionDialogListener.onOptionChosen(answer);
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
