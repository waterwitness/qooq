package com.tencent.mobileqq.activity.recent;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil.PublicAccountConfigFolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.OpenSDKUtils;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class RecentFaceDecoder
{
  public static final int a = 1000;
  private static final String jdField_a_of_type_JavaLangString = "RecentFaceDecoder";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener;
  public FaceDecoder a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this(paramQQAppInterface, paramDecodeTaskCompletionListener, false);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RecentFaceDecoder(QQAppInterface paramQQAppInterface, FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(BaseApplication.getContext(), paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramDecodeTaskCompletionListener);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.b = paramBoolean;
  }
  
  private Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ImageUtil.b();
    case 4: 
      return ImageUtil.c();
    case 101: 
    case 1001: 
      return ImageUtil.d();
    case 11: 
      return ImageUtil.b();
    case 102: 
      return ImageUtil.b(102);
    case 107: 
      return ImageUtil.b(107);
    case 103: 
      return ImageUtil.e();
    }
    return ImageUtil.b();
  }
  
  public static Pair a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int k = Integer.MIN_VALUE;
    int m = 2130838606;
    int i = m;
    int j = k;
    switch (paramInt)
    {
    default: 
      i = Integer.MIN_VALUE;
      j = k;
    }
    for (;;)
    {
      return Pair.create(Integer.valueOf(j), Integer.valueOf(i));
      i = m;
      j = k;
      if (!String.valueOf(AppConstants.aq).equals(paramString))
      {
        i = m;
        j = k;
        if (!String.valueOf(AppConstants.as).equals(paramString)) {
          if (String.valueOf(AppConstants.ag).equals(paramString))
          {
            i = 2130838609;
            j = k;
          }
          else if (AppConstants.ao.equals(paramString))
          {
            i = 2130838661;
            j = k;
          }
          else if (AppConstants.aZ.equals(paramString))
          {
            j = 110;
            i = Integer.MIN_VALUE;
          }
          else
          {
            j = 1;
            i = Integer.MIN_VALUE;
            continue;
            if (String.valueOf(AppConstants.ar).equals(paramString))
            {
              i = 2130838599;
              j = k;
            }
            else if (String.valueOf(AppConstants.aH).equals(paramString))
            {
              i = 2130840649;
              j = k;
            }
            else
            {
              j = 32;
              i = Integer.MIN_VALUE;
              continue;
              j = 102;
              i = 2130840319;
              continue;
              j = 107;
              i = 2130840317;
              continue;
              i = Integer.MIN_VALUE;
              j = 104;
              continue;
              j = 11;
              i = Integer.MIN_VALUE;
              continue;
              j = 101;
              i = Integer.MIN_VALUE;
              continue;
              j = 1001;
              i = Integer.MIN_VALUE;
              continue;
              HotChatManager localHotChatManager = paramQQAppInterface.a(false);
              if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
              {
                i = HotChatManager.a(paramString, paramQQAppInterface);
                j = k;
              }
              else
              {
                j = 4;
                i = Integer.MIN_VALUE;
                continue;
                i = 2130838598;
                j = k;
                continue;
                i = 2130840519;
                j = k;
                continue;
                i = 2130838607;
                j = k;
                continue;
                if (AppConstants.ah.equals(paramString))
                {
                  i = 2130838605;
                  j = k;
                }
                else
                {
                  j = 103;
                  i = Integer.MIN_VALUE;
                  continue;
                  i = 2130838602;
                  j = k;
                  continue;
                  i = 2130838435;
                  j = 104;
                  continue;
                  i = 2130841857;
                  j = k;
                  continue;
                  j = 108;
                  i = Integer.MIN_VALUE;
                  continue;
                  j = 105;
                  i = Integer.MIN_VALUE;
                  continue;
                  j = 111;
                  i = Integer.MIN_VALUE;
                  continue;
                  j = 106;
                  i = 2130841642;
                  continue;
                  if (TextUtils.isEmpty(PublicAccountConfigUtil.E)) {}
                  for (i = ServiceAccountFolderManager.a();; i = Integer.MAX_VALUE)
                  {
                    j = 112;
                    break;
                  }
                  i = 2130838603;
                  j = k;
                  continue;
                  i = 2130838469;
                  j = k;
                  continue;
                  i = 2130841314;
                  j = k;
                  continue;
                  i = 2130840132;
                  j = k;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public Drawable a(int paramInt, String paramString)
  {
    return a(paramInt, paramString, true);
  }
  
  public Drawable a(int paramInt, String paramString, boolean paramBoolean)
  {
    Pair localPair = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    int i = ((Integer)localPair.first).intValue();
    int j = ((Integer)localPair.second).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable uintype = " + paramInt + ", uin = " + paramString + ", isGetResFace = " + paramBoolean + ", faceType = " + i + ", faceResId = " + j);
    }
    if (j == Integer.MAX_VALUE) {}
    try
    {
      return a(i, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if (i != Integer.MIN_VALUE) {
      return a(paramString, i);
    }
    if ((j != Integer.MIN_VALUE) && (paramBoolean))
    {
      paramString = BaseApplication.getContext().getResources().getDrawable(j);
      return paramString;
    }
    return null;
  }
  
  public Drawable a(RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable start");
    }
    int i = paramRecentBaseData.a();
    if (paramRecentBaseData.a() == 8)
    {
      i = paramRecentBaseData.L;
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "getFaceDrawable type = " + i);
      }
      if (i != 0) {
        if (i == 25)
        {
          localObject = (PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
          if (localObject == null) {
            break label295;
          }
        }
      }
    }
    label295:
    for (Object localObject = ((PhoneContactManager)localObject).c(paramRecentBaseData.g);; localObject = null)
    {
      if (localObject != null)
      {
        localObject = FaceDrawable.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.g, (byte)3);
        paramRecentBaseData = (RecentBaseData)localObject;
        if (localObject == null) {
          paramRecentBaseData = ImageUtil.b();
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecentFaceDecoder", 2, "getFaceDrawable end");
        }
        return paramRecentBaseData;
        paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(16, paramRecentBaseData.a(), (byte)3, true, 16);
        if (paramRecentBaseData == null)
        {
          paramRecentBaseData = ImageUtil.b();
        }
        else
        {
          paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
          continue;
          paramRecentBaseData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramRecentBaseData.a(), (byte)3, true);
          if (paramRecentBaseData == null)
          {
            paramRecentBaseData = ImageUtil.b();
          }
          else
          {
            paramRecentBaseData = new BitmapDrawable(paramRecentBaseData);
            continue;
            paramRecentBaseData = a(i, paramRecentBaseData.a());
            continue;
            if (i != 26) {
              break;
            }
            paramRecentBaseData = OpenSDKUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a());
          }
        }
      }
      if (((paramRecentBaseData instanceof RecentCallItem)) && (((RecentCallItem)paramRecentBaseData).b())) {
        i = 3002;
      }
      for (;;)
      {
        paramRecentBaseData = a(i, paramRecentBaseData.a());
        break;
      }
    }
  }
  
  public Drawable a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentFaceDecoder", 2, "getFaceDrawable facetype = " + paramInt + ", uin = " + paramString);
    }
    if (paramInt == 104) {
      return DeviceHeadMgr.a().a(paramString);
    }
    if (paramInt == 105)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 1);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return PublicAccountConfigUtil.a(BaseApplication.getContext(), 1);
    }
    if (paramInt == 111)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 3);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return PublicAccountConfigUtil.a(BaseApplication.getContext(), 3);
    }
    if (paramInt == 106) {
      return EcShopAssistantManager.a(BaseApplication.getContext());
    }
    if (paramInt == 108) {
      return ((BlessManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).a();
    }
    if (paramInt == 110)
    {
      paramString = PublicAccountConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), 2);
      if ((paramString != null) && (paramString.a() != null)) {
        return paramString.a();
      }
      return PublicAccountConfigUtil.a(BaseApplication.getContext(), 2);
    }
    if (paramInt == 112) {
      return BaseApplicationImpl.a.getResources().getDrawable(ServiceAccountFolderManager.a());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt, paramString, false, 0);
      return null;
    }
    if ((this.b) && (!this.c))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 1");
      }
      return a(paramInt);
    }
    if (paramInt == 103) {}
    for (int i = 1;; i = paramInt)
    {
      Bitmap localBitmap;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
        if (paramInt == 32) {
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString, 200);
        }
      }
      for (;;)
      {
        Object localObject;
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("requestDecodeFace| [").append(paramString).append(",").append(paramInt).append(",").append(localBitmap).append("], isPausing=");
          if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder == null)
          {
            localObject = "null";
            label391:
            QLog.i("Q.recent", 4, localObject);
          }
        }
        else
        {
          if (localBitmap != null) {
            break label549;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b()))
          {
            if (i != 32) {
              break label499;
            }
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 200, true, false);
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RecentFaceDecoder", 2, "getFaceDrawable getDefaultFaceDrawable 2");
          }
          return a(paramInt);
          localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(i, paramString);
          break;
          localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b());
          break label391;
          label499:
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, i, true, (byte)0);
          if ((i == 1001) && (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(101, paramString) == null)) {
            this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramString, 101, true, (byte)0);
          }
        }
        label549:
        if (paramInt == 103)
        {
          paramString = BaseApplication.getContext().getResources().getDrawable(2130838594);
          if ((paramString instanceof SkinnableBitmapDrawable)) {
            ((SkinnableBitmapDrawable)paramString).setGravity(81);
          }
          if ((paramString instanceof BitmapDrawable)) {
            ((BitmapDrawable)paramString).setGravity(81);
          }
          paramString.setBounds(0, 0, paramString.getIntrinsicWidth(), paramString.getIntrinsicHeight());
          return new LayerDrawable(new Drawable[] { new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap), paramString });
        }
        return new BitmapDrawable(BaseApplication.getContext().getResources(), localBitmap);
        localBitmap = null;
      }
    }
  }
  
  public URLDrawable a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1000: 
      paramString = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(paramString);
      Drawable localDrawable = ImageUtil.c();
      return URLDrawable.getDrawable(paramString.iconUrl, localDrawable, localDrawable);
    }
    paramString = BaseApplicationImpl.a.getResources().getDrawable(ServiceAccountFolderManager.a());
    return URLDrawable.getDrawable(PublicAccountConfigUtil.E, paramString, paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder$DecodeTaskCompletionListener);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\recent\RecentFaceDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */