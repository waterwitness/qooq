package com.tencent.mobileqq.activity.qqcard;

import QCARD.CouponMobileItem;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQCardHandler;
import com.tencent.mobileqq.app.QQCardObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import osw;

public class QQCardFooter
  implements Handler.Callback, View.OnClickListener
{
  public static final int a = 2;
  public static final String a = "QQCard.QQCardFooter";
  public static final int b = 3;
  public static final int c = 5;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private QQCardActivity jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity;
  public QQCardManager a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QQCardHandler jdField_a_of_type_ComTencentMobileqqAppQQCardHandler;
  QQCardObserver jdField_a_of_type_ComTencentMobileqqAppQQCardObserver;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private View c;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private int e;
  private int f;
  
  public QQCardFooter(QQCardActivity paramQQCardActivity, QQAppInterface paramQQAppInterface, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.f = 1000;
    this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver = new osw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity = paramQQCardActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentResResources = paramQQCardActivity.getResources();
    this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler = ((QQCardHandler)paramQQAppInterface.a(69));
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager = ((QQCardManager)paramQQAppInterface.getManager(116));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130841830);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131303255));
    this.c = paramView.findViewById(2131303248);
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131303253);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131303252);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
    paramQQAppInterface = LayoutInflater.from(paramQQCardActivity).inflate(2130904584, null);
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(paramQQCardActivity, 2131558944);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    ImmersiveUtils.a(paramQQCardActivity);
    int i = ImmersiveUtils.b() - ImmersiveUtils.a(paramQQCardActivity) - paramQQCardActivity.getTitleBarHeight();
    this.jdField_d_of_type_Int = (i - QQCardConstant.w - QQCardConstant.x - QQCardConstant.v);
    this.e = (i - QQCardConstant.x - QQCardConstant.v);
  }
  
  private View a(String paramString, int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(((CouponMobileItem)this.jdField_a_of_type_JavaUtilList.get(i)).card_id))
      {
        paramString = this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(i);
        if (paramString == null) {
          break;
        }
        paramString = (TextView)paramString.findViewById(2131303259);
        a(paramString, paramInt);
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    CouponMobileItem localCouponMobileItem;
    if (paramTextView != null)
    {
      localCouponMobileItem = (CouponMobileItem)paramTextView.getTag();
      if (localCouponMobileItem != null) {}
    }
    else
    {
      return;
    }
    localCouponMobileItem.status = paramInt;
    switch (paramInt)
    {
    default: 
      paramTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366560));
      paramTextView.setEnabled(false);
      return;
    case 0: 
      paramTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366557));
      return;
    case 9: 
      paramTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366559));
      paramTextView.setEnabled(false);
      return;
    }
    paramTextView.setText(this.jdField_a_of_type_AndroidContentResResources.getString(2131366558));
    paramTextView.setEnabled(false);
  }
  
  private void a(List paramList)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("setData, size=");
      if (paramList == null) {
        break label514;
      }
      i = paramList.size();
    }
    for (;;)
    {
      QLog.d("QQCard.QQCardFooter", 2, i);
      if ((paramList == null) || (paramList.size() < 1))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      }
      try
      {
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject1 = (CouponMobileItem)paramList.next();
          View localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity).inflate(2130904587, this.jdField_a_of_type_AndroidViewViewGroup, false);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          TextView localTextView1 = (TextView)localView.findViewById(2131303259);
          Object localObject2 = (TextView)localView.findViewById(2131297123);
          TextView localTextView2 = (TextView)localView.findViewById(2131297013);
          ImageView localImageView = (ImageView)localView.findViewById(2131296790);
          if (QLog.isColorLevel()) {
            QLog.d("QQCard.QQCardFooter", 2, "notifyDataChange, " + ((CouponMobileItem)localObject1).card_id + ", " + ((CouponMobileItem)localObject1).code + ", " + ((CouponMobileItem)localObject1).field);
          }
          StringBuffer localStringBuffer = new StringBuffer();
          if (!TextUtils.isEmpty(((CouponMobileItem)localObject1).distance)) {
            localStringBuffer.append(((CouponMobileItem)localObject1).distance).append("  ");
          }
          localStringBuffer.append(QQCardConstant.a.format(new Date(((CouponMobileItem)localObject1).expire_time * 1000L)));
          if (!TextUtils.isEmpty(((CouponMobileItem)localObject1).from)) {
            localStringBuffer.append("  ").append(((CouponMobileItem)localObject1).from);
          }
          ((TextView)localObject2).setText(((CouponMobileItem)localObject1).title);
          localTextView2.setText(localStringBuffer.toString());
          localObject2 = URLDrawableHelper.a(((CouponMobileItem)localObject1).icon_url, QQCardConstant.t, QQCardConstant.t, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
          localImageView.setImageDrawable((Drawable)localObject2);
          localTextView1.setTag(localObject1);
          localTextView1.setOnClickListener(this);
          a(localTextView1, ((CouponMobileItem)localObject1).status);
          if ((((CouponMobileItem)localObject1).card_id.equals(this.jdField_b_of_type_JavaLangString)) && (((CouponMobileItem)localObject1).status == 1) && (!this.jdField_b_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(5);
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
            this.jdField_b_of_type_Boolean = false;
          }
          this.jdField_a_of_type_AndroidViewViewGroup.addView(localView, localLayoutParams);
        }
      }
      catch (IllegalArgumentException paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQCard.QQCardFooter", 2, "", paramList);
        }
        return;
        i = 0;
        continue;
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      catch (Exception paramList)
      {
        label514:
        while (!QLog.isColorLevel()) {}
        QLog.e("QQCard.QQCardFooter", 2, "", paramList);
      }
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler.a(0L, 4, 1, null, null);
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardFooter", 2, "queryRecommendCouponList");
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.c.setVisibility(paramInt);
    LinearLayout.LayoutParams localLayoutParams;
    if (paramInt == 0)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
      if (!paramBoolean) {
        break label53;
      }
    }
    label53:
    for (paramInt = this.jdField_d_of_type_Int;; paramInt = this.e)
    {
      localLayoutParams.height = paramInt;
      this.c.setLayoutParams(localLayoutParams);
      this.c.requestLayout();
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidViewView.setTag(paramString);
      return;
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void b()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQCard.QQCardFooter", 2, "onPush, cardId=" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler.a(0L, 4, 1, null, null);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppQQCardObserver);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
        continue;
        if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
        {
          this.jdField_a_of_type_AndroidAppDialog.show();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.f);
          continue;
          if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
          {
            this.jdField_a_of_type_AndroidAppDialog.show();
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.f);
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, 2, this.jdField_a_of_type_AndroidContentResResources.getString(2131366578), 1).a();
          this.jdField_b_of_type_Boolean = true;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject = (TextView)paramView;
          paramView = (CouponMobileItem)paramView.getTag();
        } while (paramView == null);
        if (QLog.isColorLevel()) {
          QLog.d("QQCard.QQCardFooter", 2, "onClick item.status=" + paramView.status);
        }
      } while ((paramView.status != 0) || (this.jdField_b_of_type_JavaLangString != null));
      this.jdField_b_of_type_JavaLangString = paramView.card_id;
      a((TextView)localObject, 9);
      this.jdField_a_of_type_ComTencentMobileqqAppQQCardHandler.a(paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a("qqcard.click.collectCoupon", 0);
      this.jdField_b_of_type_Boolean = false;
      return;
      paramView = (String)paramView.getTag();
    } while (TextUtils.isEmpty(paramView));
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.startActivity((Intent)localObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a("cardindex.disable.click", 0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */