package com.tencent.biz.qqstory.takevideo.doodle.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.control.ColorPicker;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StringUtil;
import ixi;
import ixj;
import ixk;
import ixl;
import ixm;
import ixn;

public class EditTextDialog
  extends Dialog
  implements View.OnClickListener
{
  public static final String a = "EditTextDialog";
  public final int a;
  public View a;
  public ViewTreeObserver.OnGlobalLayoutListener a;
  public EditText a;
  public TextInfo a;
  public EditTextDialog.EditTextDialogEventListener a;
  public ColorPicker a;
  public int b;
  public int c;
  public int d;
  
  public EditTextDialog(Context paramContext)
  {
    super(paramContext, 2131558676);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 420;
    this.c = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo = new TextInfo();
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_AndroidWidgetEditText.getTop();
    int j = b();
    TextPaint localTextPaint = this.jdField_a_of_type_AndroidWidgetEditText.getPaint();
    return (int)(i + j + this.jdField_a_of_type_AndroidWidgetEditText.getBaseline() + localTextPaint.ascent());
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130904446, null);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnGlobalLayoutListener = new ixn(this, null);
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ixm(this, null));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131302767));
    this.jdField_a_of_type_AndroidWidgetEditText.setPadding(TextLayer.b, 0, TextLayer.b, 0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundColor(0);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ixi(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new ixj(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnFocusChangeListener(new ixk(this));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker = ((ColorPicker)this.jdField_a_of_type_AndroidViewView.findViewById(2131302761));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker.setListener(new ixl(this));
  }
  
  private int b()
  {
    return this.d;
  }
  
  private void b()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = (DisplayUtil.b(getContext()) - b());
    localLayoutParams.flags |= 0x20;
    localLayoutParams.gravity = 80;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public int a(String paramString)
  {
    int i = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {}
    int m;
    int j;
    do
    {
      return k;
      paramString = paramString.toCharArray();
      m = paramString.length;
      j = 0;
      k = i;
    } while (j >= m);
    if (StringUtil.d(paramString[j])) {
      i += 3;
    }
    for (;;)
    {
      j += 1;
      break;
      i += 1;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(TextInfo paramTextInfo)
  {
    String str2 = paramTextInfo.a;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    paramTextInfo.a = str1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a(paramTextInfo);
    SLog.b("EditTextDialog", "setTextInfo:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.toString());
    this.jdField_a_of_type_AndroidWidgetEditText.setTextSize(DisplayUtil.c(getContext(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.d));
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.c);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a.length());
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.e == 2)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setBackgroundResource(17170445);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiControlColorPicker.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(EditTextDialog.EditTextDialogEventListener paramEditTextDialogEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener = paramEditTextDialogEventListener;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {
      return;
    }
    String str2 = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = str1;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener.a(false, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo);
  }
  
  public void setContentView(int paramInt)
  {
    this.b = AIOUtils.a(200.0F, getContext().getResources());
    b();
    a();
    super.setContentView(this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\ui\EditTextDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */