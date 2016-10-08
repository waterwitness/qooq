package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO>
  implements SimpleDraweeControllerBuilder
{
  private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
  private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener()
  {
    public void onFinalImageSet(String paramAnonymousString, @Nullable Object paramAnonymousObject, @Nullable Animatable paramAnonymousAnimatable)
    {
      if (paramAnonymousAnimatable != null) {
        paramAnonymousAnimatable.start();
      }
    }
  };
  private static final AtomicLong sIdCounter = new AtomicLong();
  private boolean mAutoPlayAnimations;
  private final Set<ControllerListener> mBoundControllerListeners;
  @Nullable
  private Object mCallerContext;
  private final Context mContext;
  @Nullable
  private ControllerListener<? super INFO> mControllerListener;
  @Nullable
  private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
  @Nullable
  private REQUEST mImageRequest;
  @Nullable
  private REQUEST mLowResImageRequest;
  @Nullable
  private REQUEST[] mMultiImageRequests;
  @Nullable
  private DraweeController mOldController;
  private boolean mRetainImageOnFailure;
  private boolean mTapToRetryEnabled;
  private boolean mTryCacheOnlyFirst;
  
  protected AbstractDraweeControllerBuilder(Context paramContext, Set<ControllerListener> paramSet)
  {
    this.mContext = paramContext;
    this.mBoundControllerListeners = paramSet;
    init();
  }
  
  protected static String generateUniqueControllerId()
  {
    return String.valueOf(sIdCounter.getAndIncrement());
  }
  
  private void init()
  {
    this.mCallerContext = null;
    this.mImageRequest = null;
    this.mLowResImageRequest = null;
    this.mMultiImageRequests = null;
    this.mTryCacheOnlyFirst = true;
    this.mControllerListener = null;
    this.mTapToRetryEnabled = false;
    this.mAutoPlayAnimations = false;
    this.mOldController = null;
  }
  
  public AbstractDraweeController build()
  {
    validate();
    if ((this.mImageRequest == null) && (this.mMultiImageRequests == null) && (this.mLowResImageRequest != null))
    {
      this.mImageRequest = this.mLowResImageRequest;
      this.mLowResImageRequest = null;
    }
    return buildController();
  }
  
  protected AbstractDraweeController buildController()
  {
    AbstractDraweeController localAbstractDraweeController = obtainController();
    localAbstractDraweeController.setRetainImageOnFailure(getRetainImageOnFailure());
    maybeBuildAndSetRetryManager(localAbstractDraweeController);
    maybeAttachListeners(localAbstractDraweeController);
    return localAbstractDraweeController;
  }
  
  public boolean getAutoPlayAnimations()
  {
    return this.mAutoPlayAnimations;
  }
  
  @Nullable
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  protected Context getContext()
  {
    return this.mContext;
  }
  
  @Nullable
  public ControllerListener<? super INFO> getControllerListener()
  {
    return this.mControllerListener;
  }
  
  protected abstract DataSource<IMAGE> getDataSourceForRequest(REQUEST paramREQUEST, Object paramObject, boolean paramBoolean);
  
  @Nullable
  public Supplier<DataSource<IMAGE>> getDataSourceSupplier()
  {
    return this.mDataSourceSupplier;
  }
  
  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST paramREQUEST)
  {
    return getDataSourceSupplierForRequest(paramREQUEST, false);
  }
  
  protected Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(final REQUEST paramREQUEST, final boolean paramBoolean)
  {
    new Supplier()
    {
      public DataSource<IMAGE> get()
      {
        return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(paramREQUEST, this.val$callerContext, paramBoolean);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("request", paramREQUEST.toString()).toString();
      }
    };
  }
  
  protected Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfREQUEST.length * 2);
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (i < paramArrayOfREQUEST.length) {}
    }
    else
    {
      i = 0;
    }
    for (;;)
    {
      if (i >= paramArrayOfREQUEST.length)
      {
        return FirstAvailableDataSourceSupplier.create(localArrayList);
        localArrayList.add(getDataSourceSupplierForRequest(paramArrayOfREQUEST[i], true));
        i += 1;
        break;
      }
      localArrayList.add(getDataSourceSupplierForRequest(paramArrayOfREQUEST[i]));
      i += 1;
    }
  }
  
  @Nullable
  public REQUEST[] getFirstAvailableImageRequests()
  {
    return this.mMultiImageRequests;
  }
  
  @Nullable
  public REQUEST getImageRequest()
  {
    return (REQUEST)this.mImageRequest;
  }
  
  @Nullable
  public REQUEST getLowResImageRequest()
  {
    return (REQUEST)this.mLowResImageRequest;
  }
  
  @Nullable
  public DraweeController getOldController()
  {
    return this.mOldController;
  }
  
  public boolean getRetainImageOnFailure()
  {
    return this.mRetainImageOnFailure;
  }
  
  public boolean getTapToRetryEnabled()
  {
    return this.mTapToRetryEnabled;
  }
  
  protected abstract BUILDER getThis();
  
  protected void maybeAttachListeners(AbstractDraweeController paramAbstractDraweeController)
  {
    Iterator localIterator;
    if (this.mBoundControllerListeners != null) {
      localIterator = this.mBoundControllerListeners.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (this.mControllerListener != null) {
          paramAbstractDraweeController.addControllerListener(this.mControllerListener);
        }
        if (this.mAutoPlayAnimations) {
          paramAbstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
        return;
      }
      paramAbstractDraweeController.addControllerListener((ControllerListener)localIterator.next());
    }
  }
  
  protected void maybeBuildAndSetGestureDetector(AbstractDraweeController paramAbstractDraweeController)
  {
    if (paramAbstractDraweeController.getGestureDetector() == null) {
      paramAbstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
    }
  }
  
  protected void maybeBuildAndSetRetryManager(AbstractDraweeController paramAbstractDraweeController)
  {
    if (!this.mTapToRetryEnabled) {
      return;
    }
    RetryManager localRetryManager2 = paramAbstractDraweeController.getRetryManager();
    RetryManager localRetryManager1 = localRetryManager2;
    if (localRetryManager2 == null)
    {
      localRetryManager1 = new RetryManager();
      paramAbstractDraweeController.setRetryManager(localRetryManager1);
    }
    localRetryManager1.setTapToRetryEnabled(this.mTapToRetryEnabled);
    maybeBuildAndSetGestureDetector(paramAbstractDraweeController);
  }
  
  protected abstract AbstractDraweeController obtainController();
  
  protected Supplier<DataSource<IMAGE>> obtainDataSourceSupplier()
  {
    if (this.mDataSourceSupplier != null)
    {
      localObject1 = this.mDataSourceSupplier;
      return (Supplier<DataSource<IMAGE>>)localObject1;
    }
    Object localObject1 = null;
    if (this.mImageRequest != null) {
      localObject1 = getDataSourceSupplierForRequest(this.mImageRequest);
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.mLowResImageRequest != null)
        {
          localObject2 = new ArrayList(2);
          ((List)localObject2).add(localObject1);
          ((List)localObject2).add(getDataSourceSupplierForRequest(this.mLowResImageRequest));
          localObject2 = IncreasingQualityDataSourceSupplier.create((List)localObject2);
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
      if (this.mMultiImageRequests != null) {
        localObject1 = getFirstAvailableDataSourceSupplier(this.mMultiImageRequests, this.mTryCacheOnlyFirst);
      }
    }
  }
  
  public BUILDER reset()
  {
    init();
    return getThis();
  }
  
  public BUILDER setAutoPlayAnimations(boolean paramBoolean)
  {
    this.mAutoPlayAnimations = paramBoolean;
    return getThis();
  }
  
  public BUILDER setCallerContext(Object paramObject)
  {
    this.mCallerContext = paramObject;
    return getThis();
  }
  
  public BUILDER setControllerListener(ControllerListener<? super INFO> paramControllerListener)
  {
    this.mControllerListener = paramControllerListener;
    return getThis();
  }
  
  public void setDataSourceSupplier(@Nullable Supplier<DataSource<IMAGE>> paramSupplier)
  {
    this.mDataSourceSupplier = paramSupplier;
  }
  
  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST)
  {
    return setFirstAvailableImageRequests(paramArrayOfREQUEST, true);
  }
  
  public BUILDER setFirstAvailableImageRequests(REQUEST[] paramArrayOfREQUEST, boolean paramBoolean)
  {
    this.mMultiImageRequests = paramArrayOfREQUEST;
    this.mTryCacheOnlyFirst = paramBoolean;
    return getThis();
  }
  
  public BUILDER setImageRequest(REQUEST paramREQUEST)
  {
    this.mImageRequest = paramREQUEST;
    return getThis();
  }
  
  public BUILDER setLowResImageRequest(REQUEST paramREQUEST)
  {
    this.mLowResImageRequest = paramREQUEST;
    return getThis();
  }
  
  public BUILDER setOldController(@Nullable DraweeController paramDraweeController)
  {
    this.mOldController = paramDraweeController;
    return getThis();
  }
  
  public BUILDER setRetainImageOnFailure(boolean paramBoolean)
  {
    this.mRetainImageOnFailure = paramBoolean;
    return getThis();
  }
  
  public BUILDER setTapToRetryEnabled(boolean paramBoolean)
  {
    this.mTapToRetryEnabled = paramBoolean;
    return getThis();
  }
  
  protected void validate()
  {
    boolean bool2 = false;
    if ((this.mMultiImageRequests != null) && (this.mImageRequest != null))
    {
      bool1 = false;
      Preconditions.checkState(bool1, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
      if (this.mDataSourceSupplier == null) {
        break label72;
      }
      bool1 = bool2;
      if (this.mMultiImageRequests == null)
      {
        bool1 = bool2;
        if (this.mImageRequest == null) {
          if (this.mLowResImageRequest == null) {
            break label72;
          }
        }
      }
    }
    label72:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      Preconditions.checkState(bool1, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
      return;
      bool1 = true;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\drawee\controller\AbstractDraweeControllerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */