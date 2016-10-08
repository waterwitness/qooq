package com.tencent.mobileqq.vas;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class SigTlpGridViewAdapter
  extends BaseAdapter
{
  private static long jdField_a_of_type_Long = 2000L;
  private static final String jdField_a_of_type_JavaLangString = "SigTlpGridViewAdapter";
  private static int c;
  private static int d;
  private static int e;
  public int a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SignatureTemplateConfig.SignatureTemplateType jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType;
  public int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public SigTlpGridViewAdapter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramQQAppInterface.getApplication());
    if (jdField_c_of_type_Int == 0)
    {
      jdField_c_of_type_Int = (EditActivity.o - DisplayUtil.a(paramQQAppInterface.getApplication(), 32.0F)) / 3;
      d = DisplayUtil.a(paramQQAppInterface.getApplication(), 64.0F) * jdField_c_of_type_Int / DisplayUtil.a(paramQQAppInterface.getApplication(), 114.0F);
      e = jdField_c_of_type_Int - DisplayUtil.a(paramQQAppInterface.getApplication(), 33.0F);
    }
  }
  
  public void a(int paramInt, SignatureTemplateConfig.SignatureTemplateType paramSignatureTemplateType)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType = paramSignatureTemplateType;
    this.b = paramInt;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SigTlpGridViewAdapter", 2, "position = " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    SignatureTemplateInfo localSignatureTemplateInfo = (SignatureTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateConfig$SignatureTemplateType.a.get(paramInt);
    Object localObject1;
    long l2;
    if (paramView == null)
    {
      paramView = new SigTlpGridViewAdapter.Holder();
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904624, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131303364));
      paramViewGroup = paramView.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      paramViewGroup.width = jdField_c_of_type_Int;
      paramViewGroup.height = d;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramViewGroup);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131303368));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(e);
      paramView.b = ((ImageView)((View)localObject1).findViewById(2131303370));
      paramView.d = ((ImageView)((View)localObject1).findViewById(2131303369));
      paramView.c = ((ImageView)((View)localObject1).findViewById(2131300966));
      ((View)localObject1).setTag(paramView);
      l2 = System.currentTimeMillis();
      QLog.d("SigTlpGridViewAdapter", 2, "position = " + paramInt + "convertView = null" + " time = " + (l2 - l1));
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = paramInt;
      paramViewGroup.d.setVisibility(4);
      paramViewGroup.c.setVisibility(4);
      if (localSignatureTemplateInfo != null)
      {
        paramView.setContentDescription(localSignatureTemplateInfo.b);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localSignatureTemplateInfo.b);
        if (localSignatureTemplateInfo.jdField_c_of_type_JavaLangString.length() <= 0) {
          break label653;
        }
      }
      try
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getXml(2131428234)));
        paramViewGroup.jdField_a_of_type_JavaLangString = localSignatureTemplateInfo.jdField_c_of_type_JavaLangString;
        label348:
        if (localSignatureTemplateInfo.jdField_a_of_type_JavaLangString.equals("0"))
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841862));
          label383:
          paramViewGroup.d.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841107));
          if (localSignatureTemplateInfo.jdField_a_of_type_Int >= 2)
          {
            if (localSignatureTemplateInfo.jdField_a_of_type_Int == 3) {
              paramViewGroup.d.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841101));
            }
            if (localSignatureTemplateInfo.jdField_a_of_type_Int == 4) {
              paramViewGroup.d.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841872));
            }
            if (SignatureManager.a(localSignatureTemplateInfo)) {
              paramViewGroup.d.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841874));
            }
            paramViewGroup.d.setVisibility(0);
          }
          if ((localSignatureTemplateInfo.jdField_c_of_type_Int == 1) || (localSignatureTemplateInfo.jdField_c_of_type_Int == 2))
          {
            if (localSignatureTemplateInfo.jdField_c_of_type_Int == 2) {
              paramViewGroup.c.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130841870));
            }
            paramViewGroup.c.setVisibility(0);
          }
          paramView.setVisibility(0);
          if (paramInt != this.b) {
            break label802;
          }
          paramViewGroup.b.setVisibility(0);
        }
        for (;;)
        {
          l2 = System.currentTimeMillis();
          QLog.d("SigTlpGridViewAdapter", 2, "position = " + paramInt + " time = " + (l2 - l1));
          return paramView;
          paramViewGroup = (SigTlpGridViewAdapter.Holder)paramView.getTag();
          break;
          label653:
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#808080"));
          break label348;
          try
          {
            localObject1 = new URL("sig_cover", localSignatureTemplateInfo.d, localSignatureTemplateInfo.jdField_a_of_type_JavaLangString);
            if (localObject1 == null) {
              break label383;
            }
            localObject1 = ((SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57)).a(Integer.parseInt(localSignatureTemplateInfo.jdField_a_of_type_JavaLangString), 19, jdField_c_of_type_Int, d);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
            if ((!(localObject1 instanceof URLDrawable)) || (((URLDrawable)localObject1).getStatus() != 2)) {
              break label383;
            }
            l2 = System.currentTimeMillis();
            if (l2 - paramViewGroup.jdField_a_of_type_Long <= jdField_a_of_type_Long) {
              break label383;
            }
            ((URLDrawable)localObject1).restartDownload();
            paramViewGroup.jdField_a_of_type_Long = l2;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              Object localObject2 = null;
            }
          }
          label802:
          paramViewGroup.b.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\SigTlpGridViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */