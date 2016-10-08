package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingRequestListener
  implements RequestListener
{
  private static final String TAG = "ForwardingRequestListener";
  private final List<RequestListener> mRequestListeners;
  
  public ForwardingRequestListener(Set<RequestListener> paramSet)
  {
    this.mRequestListeners = new ArrayList(paramSet.size());
    paramSet = paramSet.iterator();
    for (;;)
    {
      if (!paramSet.hasNext()) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)paramSet.next();
      this.mRequestListeners.add(localRequestListener);
    }
  }
  
  private void onException(String paramString, Throwable paramThrowable)
  {
    FLog.e("ForwardingRequestListener", paramString, paramThrowable);
  }
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerEvent(paramString1, paramString2, paramString3);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onIntermediateChunkStart", localException);
        }
      }
    }
  }
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithCancellation(paramString1, paramString2, paramMap);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onProducerFinishWithCancellation", localException);
        }
      }
    }
  }
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithFailure(paramString1, paramString2, paramThrowable, paramMap);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onProducerFinishWithFailure", localException);
        }
      }
    }
  }
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, @Nullable Map<String, String> paramMap)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerFinishWithSuccess(paramString1, paramString2, paramMap);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onProducerFinishWithSuccess", localException);
        }
      }
    }
  }
  
  public void onProducerStart(String paramString1, String paramString2)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onProducerStart(paramString1, paramString2);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onProducerStart", localException);
        }
      }
    }
  }
  
  public void onRequestCancellation(String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestCancellation(paramString);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onRequestCancellation", localException);
        }
      }
    }
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestFailure(paramImageRequest, paramString, paramThrowable, paramBoolean);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onRequestFailure", localException);
        }
      }
    }
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestStart(paramImageRequest, paramObject, paramString, paramBoolean);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onRequestStart", localException);
        }
      }
    }
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      RequestListener localRequestListener = (RequestListener)this.mRequestListeners.get(i);
      try
      {
        localRequestListener.onRequestSuccess(paramImageRequest, paramString, paramBoolean);
        i += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          onException("InternalListener exception in onRequestSuccess", localException);
        }
      }
    }
  }
  
  public boolean requiresExtraMap(String paramString)
  {
    int j = this.mRequestListeners.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return false;
      }
      if (((RequestListener)this.mRequestListeners.get(i)).requiresExtraMap(paramString)) {
        return true;
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\listener\ForwardingRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */