package com.tencent.mobileqq.troop.utils;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import vpg;
import vph;
import vpi;

public class TroopCommentBrowser
  extends QQBrowserActivity
{
  public int a;
  public long a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public EditText a;
  private final TextView.OnEditorActionListener jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener;
  protected TextView a;
  public TroopMemberApiClient.Callback a;
  public TroopMemberApiClient a;
  public String a;
  protected boolean a;
  
  public TroopCommentBrowser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient$Callback = new vpg(this);
    this.jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener = new vph(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new vpi(this);
  }
  
  protected int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    paramBundle = (RelativeLayout)LayoutInflater.from(getApplicationContext()).inflate(2130903887, null);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramBundle.findViewById(2131300562));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramBundle.findViewById(2131300563));
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, AIOUtils.a(50.0F, getResources()));
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b = ((ViewGroup)findViewById(2131297376));
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131297378);
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams2.bottomMargin = AIOUtils.a(50.0F, getResources());
    localView.setLayoutParams(localLayoutParams2);
    localLayoutParams1.addRule(12);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.addView(paramBundle, localLayoutParams1);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("troopUin");
    this.jdField_a_of_type_Long = paramBundle.getLong("msgseq");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("is_zan");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(4);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramBundle = getResources().getDrawable(2130840203);; paramBundle = getResources().getDrawable(2130840202))
    {
      this.jdField_a_of_type_Int = AIOUtils.a(20.0F, getResources());
      paramBundle.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBundle, null, null, null);
      return i;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_AndroidWidgetEditText != null) {
      this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopCommentBrowser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */