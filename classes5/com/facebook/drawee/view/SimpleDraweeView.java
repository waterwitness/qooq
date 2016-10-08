package com.facebook.drawee.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import javax.annotation.Nullable;

public class SimpleDraweeView
  extends GenericDraweeView
{
  private static Supplier<? extends SimpleDraweeControllerBuilder> sDraweeControllerBuilderSupplier;
  private SimpleDraweeControllerBuilder mSimpleDraweeControllerBuilder;
  
  public SimpleDraweeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public SimpleDraweeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public SimpleDraweeView(Context paramContext, GenericDraweeHierarchy paramGenericDraweeHierarchy)
  {
    super(paramContext, paramGenericDraweeHierarchy);
    init();
  }
  
  private void init()
  {
    if (isInEditMode()) {
      return;
    }
    Preconditions.checkNotNull(sDraweeControllerBuilderSupplier, "SimpleDraweeView was not initialized!");
    this.mSimpleDraweeControllerBuilder = ((SimpleDraweeControllerBuilder)sDraweeControllerBuilderSupplier.get());
  }
  
  public static void initialize(Supplier<? extends SimpleDraweeControllerBuilder> paramSupplier)
  {
    sDraweeControllerBuilderSupplier = paramSupplier;
  }
  
  public static void shutDown()
  {
    sDraweeControllerBuilderSupplier = null;
  }
  
  protected SimpleDraweeControllerBuilder getControllerBuilder()
  {
    return this.mSimpleDraweeControllerBuilder;
  }
  
  public void setImageURI(Uri paramUri)
  {
    setImageURI(paramUri, null);
  }
  
  public void setImageURI(Uri paramUri, @Nullable Object paramObject)
  {
    setController(this.mSimpleDraweeControllerBuilder.setCallerContext(paramObject).setUri(paramUri).setOldController(getController()).build());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\view\SimpleDraweeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */