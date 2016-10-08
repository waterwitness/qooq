package com.tencent.open.agent.datamodel;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.base.img.ImageCache;
import wsa;

public class ImageLoader
{
  protected static final int a = 4;
  protected static ImageLoader a;
  protected static final String a = "ImageLoader";
  public static byte[] a;
  protected static final int b = 204800;
  public LruCache a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected ImageLoader()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(50);
  }
  
  public static ImageLoader a()
  {
    if (jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader == null) {
        jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader = new ImageLoader();
      }
      return jdField_a_of_type_ComTencentOpenAgentDatamodelImageLoader;
    }
  }
  
  public Bitmap a(String arg1)
  {
    Object localObject1 = MD5Utils.b(???);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      localObject1 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(localObject1);
      return (Bitmap)localObject1;
    }
  }
  
  public void a(String paramString)
  {
    String str = MD5Utils.b(paramString);
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
      ImageCache.a(paramString);
      return;
    }
  }
  
  public void a(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    ImageCache.a("app", paramString, new wsa(this, paramImageLoadListener, paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\agent\datamodel\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */