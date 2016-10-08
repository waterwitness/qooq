package com.facebook.react.modules.fresco;

import android.net.Uri;
import android.util.Pair;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.Systrace.EventScope;
import java.util.HashMap;
import java.util.Map;

public class SystraceRequestListener
  implements RequestListener
{
  int mCurrentID = 0;
  Map<String, Pair<Integer, String>> mProducerID = new HashMap();
  Map<String, Pair<Integer, String>> mRequestsID = new HashMap();
  
  public void onProducerEvent(String paramString1, String paramString2, String paramString3)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_EVENT_");
    localStringBuilder.append(paramString1.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3.replace(':', '_'));
    Systrace.traceInstant(0L, localStringBuilder.toString(), Systrace.EventScope.THREAD);
  }
  
  public void onProducerFinishWithCancellation(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mProducerID.containsKey(paramString1)) {
      return;
    }
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }
  
  public void onProducerFinishWithFailure(String paramString1, String paramString2, Throwable paramThrowable, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mProducerID.containsKey(paramString1)) {
      return;
    }
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }
  
  public void onProducerFinishWithSuccess(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mProducerID.containsKey(paramString1)) {
      return;
    }
    paramString2 = (Pair)this.mProducerID.get(paramString1);
    Systrace.endAsyncSection(0L, (String)paramString2.second, ((Integer)paramString2.first).intValue());
    this.mProducerID.remove(paramString1);
  }
  
  public void onProducerStart(String paramString1, String paramString2)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FRESCO_PRODUCER_");
    localStringBuilder.append(paramString2.replace(':', '_'));
    paramString2 = Pair.create(Integer.valueOf(this.mCurrentID), localStringBuilder.toString());
    Systrace.beginAsyncSection(0L, (String)paramString2.second, this.mCurrentID);
    this.mProducerID.put(paramString1, paramString2);
    this.mCurrentID += 1;
  }
  
  public void onRequestCancellation(String paramString)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mRequestsID.containsKey(paramString)) {
      return;
    }
    Pair localPair = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)localPair.second, ((Integer)localPair.first).intValue());
    this.mRequestsID.remove(paramString);
  }
  
  public void onRequestFailure(ImageRequest paramImageRequest, String paramString, Throwable paramThrowable, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mRequestsID.containsKey(paramString)) {
      return;
    }
    paramImageRequest = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)paramImageRequest.second, ((Integer)paramImageRequest.first).intValue());
    this.mRequestsID.remove(paramString);
  }
  
  public void onRequestStart(ImageRequest paramImageRequest, Object paramObject, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {
      return;
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("FRESCO_REQUEST_");
    ((StringBuilder)paramObject).append(paramImageRequest.getSourceUri().toString().replace(':', '_'));
    paramImageRequest = Pair.create(Integer.valueOf(this.mCurrentID), ((StringBuilder)paramObject).toString());
    Systrace.beginAsyncSection(0L, (String)paramImageRequest.second, this.mCurrentID);
    this.mRequestsID.put(paramString, paramImageRequest);
    this.mCurrentID += 1;
  }
  
  public void onRequestSuccess(ImageRequest paramImageRequest, String paramString, boolean paramBoolean)
  {
    if (!Systrace.isTracing(0L)) {}
    while (!this.mRequestsID.containsKey(paramString)) {
      return;
    }
    paramImageRequest = (Pair)this.mRequestsID.get(paramString);
    Systrace.endAsyncSection(0L, (String)paramImageRequest.second, ((Integer)paramImageRequest.first).intValue());
    this.mRequestsID.remove(paramString);
  }
  
  public boolean requiresExtraMap(String paramString)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\modules\fresco\SystraceRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */