package com.tencent.biz.troopgift;

import android.app.Dialog;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.InputMethodLinearLayout.onSizeChangeListenner;
import java.lang.ref.WeakReference;
import jex;
import jey;
import jez;
import jfa;
import jfb;

public class TroopGiftPanel$GiftNumInputDialog
  implements View.OnClickListener, InputMethodLinearLayout.onSizeChangeListenner
{
  protected Dialog a;
  public EditText a;
  protected TextView a;
  protected TextView b;
  
  public TroopGiftPanel$GiftNumInputDialog(TroopGiftPanel paramTroopGiftPanel, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramContext, 2131558944);
    Window localWindow = this.jdField_a_of_type_AndroidAppDialog.getWindow();
    localWindow.setSoftInputMode(16);
    View localView = localWindow.getDecorView();
    if (localView != null) {
      localView.setPadding(0, 0, 0, 0);
    }
    localWindow.setGravity(80);
    localWindow.setLayout(-1, -2);
    paramContext = LayoutInflater.from(paramContext).inflate(2130903902, null);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramContext);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
    paramContext = (InputMethodLinearLayout)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300599);
    paramContext.setOnSizeChangedListenner(this);
    this.b = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300209));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131299294));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131300604));
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_AndroidWidgetEditText.setCustomSelectionActionModeCallback(new jey(this, paramTroopGiftPanel));
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(new jez(this, paramTroopGiftPanel));
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    paramContext.setOnClickListener(new jfa(this, paramTroopGiftPanel));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidAppDialog.setOnShowListener(new jfb(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new jex(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, 5) });
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void a(String paramString)
  {
    if (Long.valueOf(paramString).longValue() > 1L) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelectAllOnFocus(true);
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel$OnShowOrHideListerner.b();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.j(false);
    }
  }
  
  public void c()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.getContext().getSystemService("input_method");
    View localView = this.jdField_a_of_type_AndroidAppDialog.getWindow().peekDecorView();
    if ((localView != null) && (localView.getWindowToken() != null)) {
      localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131299294: 
      c();
      b();
      ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numcancel", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
      return;
    }
    c();
    paramView = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
    if (!TextUtils.isEmpty(paramView)) {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(paramView);
    }
    b();
    ReportController.b(null, "dc00899", "Grp_flower", "", "aio_mall", "Clk_numok", 0, 0, this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(), "", this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c, "" + TroopMemberUtil.a((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get(), ((AppInterface)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a()));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\troopgift\TroopGiftPanel$GiftNumInputDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */