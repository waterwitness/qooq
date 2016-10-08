package com.tencent.mobileqq.widget;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardHandler.NowOnliveGallayCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ProfilePhotoWall;
import com.tencent.mobileqq.data.QZonePhotoInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import wne;
import wnf;
import wng;
import wnh;
import wnk;

public class PhotoWallView
  extends FrameLayout
  implements Handler.Callback, OnGetPhotoWallListener
{
  private static final String b = "PhotoWallView";
  private static final int c = 12;
  private static final int d = 1;
  private static final int e = 2;
  private static final int f = 3;
  private static final int g = 4;
  private static final int h = 5;
  public int a;
  public Activity a;
  public Drawable a;
  public Handler a;
  public LayoutInflater a;
  protected View a;
  private CardHandler.NowOnliveGallayCallback a;
  protected CardHandler a;
  public QQAppInterface a;
  protected MyGridView a;
  protected PhotoWallView.PhotoWallUpdaterListener a;
  public String a;
  public ArrayList a;
  public LinkedList a;
  protected wnh a;
  protected wnk a;
  protected int b;
  protected View b;
  protected View c;
  
  public PhotoWallView(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, PhotoWallView.PhotoWallUpdaterListener paramPhotoWallUpdaterListener)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$NowOnliveGallayCallback = new wng(this);
    this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener = paramPhotoWallUpdaterListener;
    b();
  }
  
  public static List a(List paramList1, List paramList2)
  {
    if (paramList2.size() == 0) {
      return paramList1;
    }
    if (paramList1.size() == 0)
    {
      paramList1.addAll(paramList2);
      return paramList1;
    }
    int j = 0;
    int i = 0;
    label36:
    if (j < paramList2.size())
    {
      ProfilePhotoWall localProfilePhotoWall1 = (ProfilePhotoWall)paramList2.get(j);
      label59:
      if (i >= paramList1.size()) {
        break label131;
      }
      ProfilePhotoWall localProfilePhotoWall2 = (ProfilePhotoWall)paramList1.get(i);
      if (localProfilePhotoWall1.time >= localProfilePhotoWall2.time) {
        break label122;
      }
      int k = i + 1;
      paramList1.add(i, localProfilePhotoWall1);
      i = k;
    }
    label122:
    label131:
    for (;;)
    {
      j += 1;
      break label36;
      break;
      i += 1;
      break label59;
    }
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (ArrayList)paramMessage.obj;
    if (paramMessage != null)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      this.jdField_a_of_type_JavaUtilLinkedList.addAll(paramMessage);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
        a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilArrayList);
      }
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 12)
      {
        int i = this.jdField_a_of_type_JavaUtilLinkedList.size() - 1;
        while (i >= 12)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
          i -= 1;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFocusable(false);
      this.jdField_a_of_type_Wnh.notifyDataSetChanged();
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Wnk.c == 1) && (this.jdField_a_of_type_Wnk.jdField_a_of_type_Int < 12))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.c.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Wnk.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, ArrayList paramArrayList, List paramList)
  {
    if (this.jdField_a_of_type_Wnk == null) {
      this.jdField_a_of_type_Wnk = new wnk(this, null);
    }
    this.jdField_a_of_type_Wnk.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Wnk.c = paramInt2;
    this.jdField_a_of_type_Wnk.jdField_a_of_type_JavaLangString = paramString;
    if (paramArrayList != null)
    {
      paramString = paramArrayList.iterator();
      while (paramString.hasNext())
      {
        paramArrayList = (PhotoWall)paramString.next();
        QZonePhotoInfo localQZonePhotoInfo = new QZonePhotoInfo();
        localQZonePhotoInfo.uin = this.jdField_a_of_type_JavaLangString;
        localQZonePhotoInfo.time = paramArrayList.ctime;
        localQZonePhotoInfo.photoId = paramArrayList.photoId;
        localQZonePhotoInfo.photoUrls = paramArrayList.photoUrls;
        paramList.add(localQZonePhotoInfo);
      }
      this.jdField_a_of_type_Wnk.jdField_a_of_type_Int = paramList.size();
    }
  }
  
  public void a(boolean paramBoolean, String paramString, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
    }
    while (parammobile_sub_get_photo_wall_rsp == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString)) {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    }
    a(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, localArrayList);
    paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    paramString.obj = localArrayList;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Wnk != null) {
      return this.jdField_a_of_type_Wnk.c == 1;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getContext());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904303, this, true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302242));
    this.jdField_a_of_type_Wnh = new wnh(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Wnh);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302243);
    this.c = this.jdField_a_of_type_AndroidViewView.findViewById(2131302244);
    this.c.setOnClickListener(new wne(this));
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int i = Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    if (i <= 240) {
      this.jdField_a_of_type_Int = 60;
    }
    for (;;)
    {
      ThreadManager.a(new wnf(this), 5, null, true);
      return;
      if (i <= 320) {
        this.jdField_a_of_type_Int = 100;
      } else {
        this.jdField_a_of_type_Int = 160;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 3: 
    case 1: 
    case 2: 
    case 4: 
      do
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "load photo wall ");
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_JavaLangString, "");
        try
        {
          long l = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(l, this.jdField_a_of_type_ComTencentMobileqqAppCardHandler$NowOnliveGallayCallback);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
          return true;
        }
        catch (NumberFormatException paramMessage)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("PhotoWallView", 2, QLog.getStackTraceString(paramMessage));
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "load from db ");
        }
        a(paramMessage);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener != null) && (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener.a(this.jdField_a_of_type_JavaUtilLinkedList.size());
        }
        paramMessage = Message.obtain();
        paramMessage.what = 3;
        handleMessage(paramMessage);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoWallView", 2, "load from server ");
        }
        this.jdField_b_of_type_Int |= 0x1;
        a(paramMessage);
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener != null) && (this.jdField_b_of_type_Int == 17)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener.a(this.jdField_a_of_type_JavaUtilLinkedList.size());
        }
        if ((this.jdField_a_of_type_Wnk.jdField_a_of_type_Int >= 12) && (this.jdField_a_of_type_Wnk.jdField_b_of_type_Int > 12))
        {
          ((TextView)this.c.findViewById(2131302245)).setText(this.jdField_a_of_type_Wnk.jdField_b_of_type_Int + "张照片，" + getResources().getString(2131370457));
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.c.setVisibility(0);
          return true;
        }
        if (this.jdField_a_of_type_Wnk.c != 1) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.c.setVisibility(8);
        return true;
        this.jdField_b_of_type_Int |= 0x10;
        a(this.jdField_a_of_type_JavaUtilLinkedList, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Wnh.notifyDataSetChanged();
      } while ((this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener == null) || (this.jdField_b_of_type_Int != 17));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPhotoWallView$PhotoWallUpdaterListener.a(this.jdField_a_of_type_JavaUtilLinkedList.size());
      return true;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    QQToast.a(getContext(), 1, 2131372037, 0).a();
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\widget\PhotoWallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */