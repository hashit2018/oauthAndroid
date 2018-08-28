package com.example.authorlibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public class MiddleDialog<E> extends Dialog {
    private onButtonCLickListener2 listener2;
    private int position;
    private View view;
    /**
     *     确认与取消
     *
     * */
    public MiddleDialog(Context context, final onButtonCLickListener2<E> listener, int theme) {
        super(context, theme);
        view = View.inflate(context, R.layout.dialog_middle, null);
        setContentView(view);
        setCancelable(false);
        this.listener2 = listener;
        view.findViewById(R.id.ok).setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View v) {
                dismiss();
                listener2.onActivieButtonClick("1", position);
            }
        });
        view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {//取消
            @Override
            public void onClick(View v) {
                dismiss();
                listener2.onActivieButtonClick(null, position);
            }
        });
    }
    public interface onButtonCLickListener2<E>{
        void onActivieButtonClick(E bean, int position);
    }
}
