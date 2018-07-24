package io.xdag.xdagwallet.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import io.xdag.common.base.BaseDialogFragment;
import io.xdag.xdagwallet.R;

/**
 * created by lxm on 2018/7/24.
 */
public class LoadingDialog extends BaseDialogFragment {

    public static LoadingDialog newInstance(String message, boolean cancelable) {
        LoadingDialog dialog = new LoadingDialog();
        dialog.setArguments(getBaseBundle(message, cancelable));
        return dialog;
    }


    @NonNull @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_loading, null);
        TextView tvLoading = view.findViewById(R.id.dialog_loading_tv);

        if (!TextUtils.isEmpty(mMessage)) {
            tvLoading.setText(mMessage);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
            .setView(view);
        setCancelable(mCancelable);
        return builder.create();

    }


    public static LoadingDialog show(String message, boolean cancelable, FragmentManager fragmentManager) {
        LoadingDialog dialog = newInstance(message, cancelable);
        dialog.show(fragmentManager);
        return dialog;
    }
}