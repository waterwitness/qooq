package com.tencent.mobileqq.rn;

import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.NearbyUtils;

public class RCTAvatarViewManager
  extends SimpleViewManager
{
  private static final String REACT_CLASS = "RCTAvatar";
  static final String TAG = RCTAvatarViewManager.class.getSimpleName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String getStaticName()
  {
    return "RCTAvatar";
  }
  
  protected RCTAvatar createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new RCTAvatar(paramThemedReactContext);
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  @ReactProp(name="defaultImageUri")
  public void setDefaultImageUri(RCTAvatar paramRCTAvatar, String paramString) {}
  
  @ReactProp(name="headId")
  public void setHeadId(RCTAvatar paramRCTAvatar, String paramString)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "setHeadId", new Object[] { paramString });
    }
    paramRCTAvatar.setHeadId(paramString);
  }
  
  @ReactProp(name="headShape")
  public void setHeadShape(RCTAvatar paramRCTAvatar, String paramString)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "setHeadShape", new Object[] { paramString });
    }
    if ("default".equals(paramString)) {
      paramRCTAvatar.setHeadShape(3);
    }
    do
    {
      return;
      if ("square".equals(paramString))
      {
        paramRCTAvatar.setHeadShape(1);
        return;
      }
      if ("round".equals(paramString))
      {
        paramRCTAvatar.setHeadShape(2);
        return;
      }
      if ("circle".equals(paramString))
      {
        paramRCTAvatar.setHeadShape(3);
        return;
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a(TAG, "setHeadShape_invalide_value", new Object[] { paramString });
  }
  
  @ReactProp(name="headIdType")
  public void setIdType(RCTAvatar paramRCTAvatar, String paramString)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "setIdType", new Object[] { paramString });
    }
    if ("Uin".equals(paramString)) {
      paramRCTAvatar.setHeadIdType(200);
    }
    do
    {
      return;
      if ("TinnyId".equals(paramString))
      {
        paramRCTAvatar.setHeadIdType(202);
        return;
      }
      if ("OpenId".equals(paramString))
      {
        paramRCTAvatar.setHeadIdType(204);
        return;
      }
    } while (!NearbyUtils.a());
    NearbyUtils.a(TAG, "setIdType_invalide_value", new Object[] { paramString });
  }
  
  public void updateExtraData(RCTAvatar paramRCTAvatar, Object paramObject)
  {
    if (NearbyUtils.a()) {
      NearbyUtils.a(TAG, "updateExtraData", new Object[] { paramObject });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\rn\RCTAvatarViewManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */