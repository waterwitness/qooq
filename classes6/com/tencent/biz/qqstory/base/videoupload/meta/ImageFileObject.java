package com.tencent.biz.qqstory.base.videoupload.meta;

import com.tencent.biz.qqstory.base.videoupload.job.ImageUploadJobSegment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.ThrottlingFunction;
import com.tribe.async.reactive.Stream;
import iif;
import iig;

public class ImageFileObject
  extends UploadObject
{
  public static final String a = "Q.qqstory.publish:ImageFileObject       ";
  public iif a;
  public boolean a;
  public String b;
  public String c;
  
  public ImageFileObject(boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new iif(this, null);
    ImageUploadJobSegment localImageUploadJobSegment = new ImageUploadJobSegment();
    if (paramBoolean) {
      localImageUploadJobSegment.a(2);
    }
    Stream.fromDataPusher(this.a).map(new ThrottlingFunction(2, 16)).map(localImageUploadJobSegment).subscribe(new iig(this, null));
  }
  
  protected void a()
  {
    this.a.a(this.b);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\meta\ImageFileObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */