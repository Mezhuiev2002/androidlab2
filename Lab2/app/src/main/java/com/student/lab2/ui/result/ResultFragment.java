package com.student.lab2.ui.result;

import static com.student.lab2.constants.ConstantsKey.KEY_PASSWORD_BUNDLE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.student.lab2.R;

public class ResultFragment extends Fragment {

    private ConstraintLayout root;
    private TextView textPasswordResult;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findViews(view);
        initVariables();
        setClicks();
        retrieveBundle();
    }

    private void findViews(View view) {
        root = view.findViewById(R.id.root_result);
        textPasswordResult = view.findViewById(R.id.text_password_result);
    }

    private void initVariables() {

    }

    private void setClicks() {

    }

    private void retrieveBundle() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            getParentFragmentManager().popBackStack();
            return;
        }

        String password = bundle.getString(KEY_PASSWORD_BUNDLE);

        if (password.isEmpty()) {
            showErrorSnack();
        }

        showResult(password);

    }

    private void showResult(String password) {
        textPasswordResult.setText(password);
    }

    private void showErrorSnack() {
        Snackbar snackbar = Snackbar.make(requireContext(), root, "Password is empty :/", Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}