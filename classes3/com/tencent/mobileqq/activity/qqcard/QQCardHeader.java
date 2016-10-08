package com.tencent.mobileqq.activity.qqcard;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqwifi.VacContentServlet;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;
import osx;

public class QQCardHeader
  implements View.OnClickListener, ActionSheet.OnButtonClickListener, BusinessObserver
{
  public static final String a = "QQCard.QQCardHeader";
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLDrawableDownListener jdField_a_of_type_ComTencentImageURLDrawableDownListener;
  private QQCardActivity jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity;
  private QQCardHeader.QQCardHeaderListener jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader$QQCardHeaderListener;
  private QQCardManager jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ADView a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  List jdField_a_of_type_JavaUtilList;
  NewIntent jdField_a_of_type_MqqAppNewIntent;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  View b;
  
  public QQCardHeader(QQCardActivity paramQQCardActivity, View paramView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener = new osx(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity = paramQQCardActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQCardActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager = ((QQCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(116));
    this.jdField_a_of_type_AndroidWidgetImageView = paramQQCardActivity.rightViewImg;
    this.jdField_a_of_type_ComTencentMobileqqWidgetADView = ((ADView)paramView.findViewById(2131303258));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131303256);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131301449));
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131303257);
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), VacContentServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("content_id", 8);
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    try
    {
      paramView = (JSONObject)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Intent localIntent;
      if ("附近卡券".equals(paramView.getString("menu_title")))
      {
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, NearbyQQCardActivity.class);
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.startActivity(localIntent);
      }
      for (;;)
      {
        if (paramView.has("report_id")) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a(paramView.getString("report_id"), 0);
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
        localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView.getString("jump_url"));
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.startActivity(localIntent);
      }
      return;
    }
    catch (Exception paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQCard.QQCardHeader", 2, "", paramView);
      }
    }
  }
  
  public void a()
  {
    Object localObject = VacContentServlet.a("qqcard");
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardHeader", 2, "initBannerAndTip, " + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("cornerMenu"))
          {
            this.jdField_a_of_type_OrgJsonJSONArray = ((JSONObject)localObject).getJSONArray("cornerMenu");
            if (this.jdField_a_of_type_OrgJsonJSONArray.length() > 0)
            {
              this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("菜单");
              this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
              this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
            }
          }
          if (((JSONObject)localObject).has("tip"))
          {
            localObject = ((JSONObject)localObject).getJSONObject("tip");
            int i = ((JSONObject)localObject).getInt("end_time");
            int j = ((JSONObject)localObject).getInt("start_time");
            long l = System.currentTimeMillis() / 1000L;
            if ((i != 0) && (l < i) && (l > j))
            {
              i = ((JSONObject)localObject).getInt("id");
              if (!this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a(i))
              {
                this.jdField_a_of_type_AndroidWidgetTextView.setText(((JSONObject)localObject).getString("text"));
                this.jdField_a_of_type_AndroidViewView.setVisibility(0);
                this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
                this.jdField_a_of_type_AndroidViewView.setTag(localObject);
                return;
              }
            }
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("QQCard.QQCardHeader", 2, "", localException);
  }
  
  public void a(QQCardHeader.QQCardHeaderListener paramQQCardHeaderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader$QQCardHeaderListener = paramQQCardHeaderListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = (String)paramView.getTag();
      Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.startActivity(localIntent);
      return;
      paramView = (JSONObject)paramView.getTag();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a(paramView.getInt("id"), true);
        paramView = paramView.getString("url");
        if (!TextUtils.isEmpty(paramView))
        {
          localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity, QQBrowserActivity.class);
          localIntent.putExtra("url", paramView);
          this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.startActivity(localIntent);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQCard.QQCardHeader", 2, "", paramView);
          }
        }
      }
    } while (((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) || (this.jdField_a_of_type_OrgJsonJSONArray == null) || (this.jdField_a_of_type_OrgJsonJSONArray.length() <= 0));
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.c(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity);
    int i = 0;
    try
    {
      while (i < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        paramView = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i);
        this.jdField_a_of_type_JavaUtilList.add(paramView);
        this.jdField_a_of_type_ComTencentWidgetActionSheet.c(paramView.getString("menu_title"));
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d(this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.getString(2131367262));
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQCard.QQCardHeader", 2, "", paramView);
        }
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardHeader", 2, "onReceive, " + paramInt + ", " + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    paramBundle = paramBundle.getString("key_data");
    if (QLog.isColorLevel()) {
      QLog.d("QQCard.QQCardHeader", 2, "onReceive, json=" + paramBundle);
    }
    for (;;)
    {
      long l;
      Object localObject;
      int i;
      try
      {
        l = System.currentTimeMillis() / 1000L;
        paramBundle = new JSONObject(paramBundle);
        if (!paramBundle.has("banner")) {
          break label388;
        }
        localObject = paramBundle.getJSONArray("banner");
        Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.getResources().getDrawable(2130838381);
        paramInt = 0;
        if (paramInt >= ((JSONArray)localObject).length()) {
          break label361;
        }
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(paramInt);
        i = localJSONObject.getInt("end_time");
        int j = localJSONObject.getInt("start_time");
        if ((l >= i) || (l <= j)) {
          break label731;
        }
        FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardActivity.getLayoutInflater().inflate(2130904583, null);
        URLImageView localURLImageView = (URLImageView)localFrameLayout.findViewById(2131296303);
        URLDrawable localURLDrawable = URLDrawableHelper.a(localJSONObject.getString("img_url"), localDrawable, localDrawable);
        if (localURLDrawable.getStatus() == 1)
        {
          i = (int)(localURLDrawable.getIntrinsicHeight() / localURLDrawable.getIntrinsicWidth() * (float)DeviceInfoUtil.h() + 0.5F);
          ((LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetADView.getLayoutParams()).height = i;
          localURLImageView.setImageDrawable(localURLDrawable);
          localURLImageView.setTag(localJSONObject.getString("jump_url"));
          localURLImageView.setOnClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetADView.a(localFrameLayout, paramInt);
          break label731;
        }
        localURLImageView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramBundle) {}
      QLog.e("QQCard.QQCardHeader", 2, "", paramBundle);
      return;
      label361:
      if (paramInt > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.setCircle(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.h();
        label388:
        if (!paramBundle.has("cornerMenu")) {
          break label671;
        }
        this.jdField_a_of_type_OrgJsonJSONArray = paramBundle.getJSONArray("cornerMenu");
        if (this.jdField_a_of_type_OrgJsonJSONArray.length() <= 0) {
          break label635;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("菜单");
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838587);
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
        label452:
        if (!paramBundle.has("tip")) {
          break label719;
        }
        localObject = paramBundle.getJSONObject("tip");
        paramInt = ((JSONObject)localObject).getInt("end_time");
        i = ((JSONObject)localObject).getInt("start_time");
        if ((paramInt == 0) || (l >= paramInt) || (l <= i)) {
          break label707;
        }
        paramInt = ((JSONObject)localObject).getInt("id");
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardManager.a(paramInt))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(((JSONObject)localObject).getString("text"));
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
          this.jdField_a_of_type_AndroidViewView.setTag(localObject);
        }
      }
      for (;;)
      {
        if (!paramBundle.has("switch")) {
          break label729;
        }
        this.jdField_a_of_type_Int = paramBundle.getJSONObject("switch").getInt("is_recommend_open");
        if ((this.jdField_a_of_type_Int != 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader$QQCardHeaderListener == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQqcardQQCardHeader$QQCardHeaderListener.a();
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetADView.setVisibility(8);
        break label388;
        label635:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          break label452;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        break label452;
        label671:
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if ((this.jdField_a_of_type_ComTencentWidgetActionSheet == null) || (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          break label452;
        }
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        break label452;
        label707:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        continue;
        label719:
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      label729:
      break;
      label731:
      paramInt += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */