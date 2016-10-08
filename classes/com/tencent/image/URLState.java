package com.tencent.image;

import android.app.PendingIntent.CanceledException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

final class URLState
  extends Drawable.ConstantState
{
  static final String CACHE_PREFIX = "Cache_";
  static final Object FILE_DOWNLOADED = new Object();
  private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
  static HashMap<String, WeakReference<URLState>> sUnFinishImageCache = new HashMap();
  private Vector<WeakReference<Callback>> callbacks = new Vector();
  boolean isFlashPicNeedCache = false;
  File mCacheFile;
  boolean mDecodeFile;
  private final Object mDecodeFileLock = new Object();
  boolean mDither = true;
  int mHeight = 0;
  boolean mIgnorePause = false;
  int mIsLoadingStarted = 0;
  int mOrientation = 0;
  DownloadParams mParams = new DownloadParams();
  int mProgress = 0;
  ProtocolDownloader mProtocolDownloader;
  int mStatus = 0;
  Drawable.ConstantState mSuccessed;
  PreDownloadRunnable mTask;
  URL mUrl;
  String mUrlStr;
  boolean mUseMemoryCache = true;
  int mWidth = 0;
  
  URLState(URL arg1, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.mUrl = ???;
    this.isFlashPicNeedCache = paramURLDrawableOptions.isFlashPic;
    this.mUrlStr = ???.toString();
    this.mUseMemoryCache = paramURLDrawableOptions.mUseMemoryCache;
    this.mProtocolDownloader = URLDrawable.sDefaultDrawableParms.getDownloader(???.getProtocol());
    if ((this.mProtocolDownloader == null) && (QLog.isDevelopLevel())) {
      QLog.e("URLDrawable_", 4, "No comfortable downloader. url:" + ??? + "protocol" + ???.getProtocol());
    }
    synchronized (URLDrawable.sMemoryCache)
    {
      sUnFinishImageCache.put(this.mUrlStr, new WeakReference(this));
      return;
    }
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      m = 1;
    }
    int j;
    int k;
    int i;
    label39:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        i = 1;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    int m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k >>= 1;
      j >>= 1;
      i <<= 1;
      break label39;
      n = m;
    }
  }
  
  private Object decodeFile(File paramFile, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    Object localObject1 = null;
    Object localObject2 = this.mProtocolDownloader;
    if (localObject2 != null)
    {
      paramURLDrawableHandler = ((ProtocolDownloader)localObject2).decodeFile(paramFile, this.mParams, paramURLDrawableHandler);
      localObject1 = paramURLDrawableHandler;
      if (paramURLDrawableHandler != null)
      {
        this.mOrientation = this.mParams.outOrientation;
        this.mWidth = this.mParams.outWidth;
        this.mHeight = this.mParams.outHeight;
      }
    }
    do
    {
      return paramURLDrawableHandler;
      if ((paramFile == null) || (!paramFile.exists())) {
        return null;
      }
      if ((localObject2 != null) && (((ProtocolDownloader)localObject2).gifHasDifferentState())) {}
      for (boolean bool = true; VideoDrawable.isVideo(paramFile); bool = false) {
        return new NativeVideoImage(paramFile, true, this.mParams.reqWidth, this.mParams.reqHeight, this.mParams.mExtraInfo);
      }
      if ((GifDrawable.isGifFile(paramFile)) && ((bool) || (this.mParams.useGifAnimation))) {
        return NativeGifFactory.getNativeGifObject(paramFile, bool, false, this.mParams.reqWidth, this.mParams.reqHeight, this.mParams.mGifRoundCorner);
      }
      if ((ApngImage.needDecodeAnimation(paramFile)) && (this.mParams.useApngImage)) {
        return new ApngImage(paramFile, bool);
      }
      if ((!this.mParams.useSharpPImage) || (!SharpPUtil.isSharpPFile(paramFile))) {
        break;
      }
      localObject2 = new File(NativeGifIndex8.getSoLibPath(URLDrawable.mApplicationContext) + "libTcHevcDec.so");
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "soLibFile = " + ((File)localObject2).getAbsolutePath() + " exists = " + ((File)localObject2).exists());
      }
      paramURLDrawableHandler = (URLDrawableHandler)localObject1;
    } while (!((File)localObject2).exists());
    return SharpPUtil.decodeSharpPByFilePath(paramFile.getAbsolutePath());
    paramFile = paramFile.getAbsolutePath();
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    ((BitmapFactory.Options)localObject1).inPreferredConfig = URLDrawable.sDefaultDrawableParms.mConfig;
    ((BitmapFactory.Options)localObject1).inDensity = 160;
    ((BitmapFactory.Options)localObject1).inTargetDensity = 160;
    ((BitmapFactory.Options)localObject1).inScreenDensity = 160;
    SafeBitmapFactory.decodeFile(paramFile, (BitmapFactory.Options)localObject1);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inSampleSize = calculateInSampleSize((BitmapFactory.Options)localObject1, this.mParams.reqWidth, this.mParams.reqHeight);
    paramURLDrawableHandler = SafeBitmapFactory.decodeFile(paramFile, (BitmapFactory.Options)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_", 2, "decodeFile:sampleSize=" + ((BitmapFactory.Options)localObject1).inSampleSize + ", requestSize=" + this.mParams.reqWidth + "," + this.mParams.reqHeight + " " + this.mUrlStr);
    }
    if (paramURLDrawableHandler == null) {
      throw new IOException("decode cache file failed: " + paramFile);
    }
    this.mOrientation = JpegExifReader.readOrientation(paramFile);
    paramFile = paramURLDrawableHandler;
    if (this.mParams.mDecodeHandler != null) {
      paramFile = this.mParams.mDecodeHandler.run(this.mParams, paramURLDrawableHandler);
    }
    if ((Build.VERSION.SDK_INT >= 11) && (SliceBitmap.needSlice(paramFile)))
    {
      paramURLDrawableHandler = new SliceBitmap(paramFile);
      paramFile.recycle();
      return paramURLDrawableHandler;
    }
    return paramFile;
  }
  
  static URLState getConstants(String paramString)
  {
    synchronized (URLDrawable.sMemoryCache)
    {
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
      paramString = (Pair)URLDrawable.sMemoryCache.get(paramString);
      if ((paramString != null) && ((paramString.first instanceof URLState))) {
        return (URLState)paramString.first;
      }
    }
    return null;
  }
  
  static URLState getConstants(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    synchronized (URLDrawable.sMemoryCache)
    {
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        if (paramURLDrawableOptions.isFlashPic != ((URLState)localWeakReference.get()).isFlashPicNeedCache) {
          return null;
        }
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
    }
    paramString = (Pair)URLDrawable.sMemoryCache.get(paramString);
    if ((paramString != null) && ((paramString.first instanceof URLState)))
    {
      if (paramURLDrawableOptions.isFlashPic != ((URLState)paramString.first).isFlashPicNeedCache) {
        return null;
      }
      return (URLState)paramString.first;
    }
    return null;
  }
  
  private static int getImageByteSize(Object paramObject)
  {
    if ((paramObject instanceof Bitmap)) {
      return Utils.getBitmapSize((Bitmap)paramObject);
    }
    if ((paramObject instanceof SliceBitmap)) {
      return ((SliceBitmap)paramObject).getByteCount();
    }
    if ((paramObject instanceof AbstractGifImage)) {
      return ((AbstractGifImage)paramObject).getByteSize();
    }
    if (NativeVideoImage.class.isInstance(paramObject)) {
      return ((NativeVideoImage)paramObject).getByteSize();
    }
    if (QQLiveImage.class.isInstance(paramObject)) {
      return ((QQLiveImage)paramObject).getByteSize();
    }
    if (RoundRectBitmap.class.isInstance(paramObject)) {
      return ((RoundRectBitmap)paramObject).getByteSize();
    }
    return 1048576;
  }
  
  private void pauseThread()
  {
    if ((this.mIgnorePause) || (Looper.myLooper() == Looper.getMainLooper())) {
      return;
    }
    synchronized (URLDrawable.sPauseLock)
    {
      for (;;)
      {
        boolean bool = URLDrawable.sPause;
        if (!bool) {
          break;
        }
        try
        {
          URLDrawable.sPauseLock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
  }
  
  void addCallBack(Callback paramCallback)
  {
    if (paramCallback != null) {
      this.callbacks.add(new WeakReference(paramCallback));
    }
  }
  
  void downloadImediatly(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat)
  {
    if ((this.mStatus == 1) || (this.mIsLoadingStarted > 0)) {
      return;
    }
    this.mIsLoadingStarted += 1;
    this.mDecodeFile = paramBoolean1;
    this.mParams.cookies = paramCookieStore;
    this.mParams.headers = paramArrayOfHeader;
    this.mParams.tag = paramObject;
    this.mParams.useGifAnimation = paramBoolean2;
    this.mParams.useApngImage = paramBoolean3;
    this.mParams.useSharpPImage = paramBoolean4;
    this.mParams.mGifRoundCorner = paramFloat;
    this.mParams.needCheckNetType = false;
    try
    {
      paramArrayOfHeader = loadImage(this.mUrl, new URLDrawableHandler.Adapter());
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label204;
      }
      paramCookieStore = paramArrayOfHeader;
    }
    catch (Throwable paramArrayOfHeader)
    {
      do
      {
        paramArrayOfHeader = paramArrayOfHeader;
        paramCookieStore = paramArrayOfHeader;
      } while (Looper.myLooper() == Looper.getMainLooper());
      paramObject = UI_HANDLER;
      paramCookieStore = new PostOnResult(paramArrayOfHeader);
      paramArrayOfHeader = (Header[])paramObject;
      paramArrayOfHeader.post(paramCookieStore);
      return;
    }
    finally
    {
      for (;;)
      {
        paramArrayOfHeader = finally;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          onResult(null);
        }
        for (;;)
        {
          throw paramArrayOfHeader;
          UI_HANDLER.post(new PostOnResult(null));
        }
        paramCookieStore = UI_HANDLER;
        paramObject = new PostOnResult(paramArrayOfHeader);
        paramArrayOfHeader = paramCookieStore;
        paramCookieStore = (CookieStore)paramObject;
      }
    }
    onResult(paramCookieStore);
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  Object loadImage(URL paramURL, URLDrawableHandler paramURLDrawableHandler)
    throws Throwable
  {
    paramURL = null;
    pauseThread();
    if (this.mProtocolDownloader != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "call downloader loadImage." + this.mUrlStr);
      }
      paramURL = this.mProtocolDownloader.loadImageFile(this.mParams, paramURLDrawableHandler);
      this.mCacheFile = paramURL;
    }
    for (;;)
    {
      Pair localPair;
      synchronized (this.mDecodeFileLock)
      {
        if (!this.mDecodeFile)
        {
          this.mStatus = 4;
          this.mIsLoadingStarted -= 1;
          paramURL = FILE_DOWNLOADED;
          return paramURL;
        }
        this.mStatus = 4;
        paramURL = decodeFile(paramURL, paramURLDrawableHandler);
        if (paramURL != null)
        {
          if (!(paramURL instanceof Bitmap)) {
            break label262;
          }
          ??? = this.mUrl.getPath();
          ??? = new RegionDrawable(null, (Bitmap)paramURL, (String)???);
          ((RegionDrawable)???).setDither(this.mDither);
          this.mSuccessed = ((RegionDrawable)???).getConstantState();
          localPair = new Pair(this, Integer.valueOf(getImageByteSize(paramURL)));
        }
      }
      synchronized (URLDrawable.sMemoryCache)
      {
        sUnFinishImageCache.remove(this.mUrlStr);
        if (this.mUseMemoryCache) {
          URLDrawable.sMemoryCache.put(this.mUrlStr, localPair);
        }
        this.mStatus = 1;
        pauseThread();
        paramURLDrawableHandler.publishProgress(10000);
        if (paramURL == null)
        {
          throw new NullPointerException("bitmap decode failed");
          paramURL = finally;
          throw paramURL;
          label262:
          if ((paramURL instanceof SliceBitmap))
          {
            ??? = new SliceBitmapDrawable.BitmapState((SliceBitmap)paramURL);
            ((SliceBitmapDrawable.BitmapState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof AbstractGifImage))
          {
            ??? = new GifDrawable.GifState((AbstractGifImage)paramURL);
            ((GifDrawable.GifState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof ApngImage))
          {
            ??? = new ApngDrawable.ApngState((ApngImage)paramURL);
            ((ApngDrawable.ApngState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof RoundRectBitmap))
          {
            ??? = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap)paramURL);
            ((RoundRectDrawable.RoundRectDrawableState)???).mBorderPaint.setDither(this.mDither);
            ((RoundRectDrawable.RoundRectDrawableState)???).mBitmapPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof AbstractVideoImage))
          {
            ??? = new VideoDrawable.VideoState((AbstractVideoImage)paramURL);
            ((VideoDrawable.VideoState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof QQLiveImage))
          {
            ??? = new QQLiveDrawable.QQLiveState((QQLiveImage)paramURL);
            ((QQLiveDrawable.QQLiveState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          throw new RuntimeException("Invalide image type " + paramURL.getClass().getSimpleName());
        }
      }
    }
    if (this.mSuccessed == null) {
      throw new NullPointerException("mSuccessed is null...");
    }
    return paramURL;
  }
  
  public Drawable newDrawable()
  {
    return new URLDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new URLDrawable(this, paramResources);
  }
  
  void onFileDownloaded()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawable_", 4, "download successed, URLState: " + this + " , url: " + this.mUrlStr + "\nnotify " + this.callbacks.size() + " callbacks");
    }
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          localObject1 = (WeakReference)this.callbacks.get(i);
          if (localObject1 != null)
          {
            localObject1 = (Callback)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              ((Callback)localObject1).onFileDownloaded(this);
              continue;
            }
            localObject1 = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally
      {
        Object localObject1;
        int j;
        continue;
        i += 1;
      }
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
      }
      finally
      {
        continue;
      }
      throw ((Throwable)localObject1);
      localObject1 = this.callbacks;
      j = i - 1;
      ((Vector)localObject1).remove(i);
      i = j;
      continue;
      return;
    }
  }
  
  void onLoadCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawable_", 2, "[onLoadCancelled]" + this.mUrlStr);
    }
    this.mStatus = 3;
    this.mIsLoadingStarted -= 1;
    int i = 0;
    for (;;)
    {
      if (i < this.callbacks.size()) {}
      synchronized (this.callbacks)
      {
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        int k;
        int j;
        if (localObject1 != null)
        {
          localObject1 = (Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((Callback)localObject1).onLoadCanceled(this);
            i += 1;
            continue;
          }
          localObject1 = this.callbacks;
          k = i - 1;
          j = k;
        }
        for (;;)
        {
          try
          {
            ((Vector)localObject1).remove(i);
            i = k;
            break;
          }
          finally {}
          localObject1 = this.callbacks;
          k = i - 1;
          j = k;
          ((Vector)localObject1).remove(i);
          i = k;
        }
        throw ((Throwable)localObject2);
        return;
      }
    }
  }
  
  void onLoadFailed(Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("URLDrawable_", 4, wrapLog("URLState onLoadFailed():"), paramThrowable);
    }
    this.mStatus = 2;
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if (localObject != null)
          {
            localObject = (Callback)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((Callback)localObject).onLoadFailed(this, paramThrowable);
              continue;
            }
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally
      {
        Object localObject;
        int j;
        continue;
        i += 1;
      }
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
      }
      finally
      {
        continue;
      }
      throw paramThrowable;
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
      continue;
      return;
    }
  }
  
  /* Error */
  void onLoadStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 109	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: iconst_0
    //   8: istore_3
    //   9: iload_3
    //   10: aload_0
    //   11: getfield 109	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   14: invokevirtual 656	java/util/Vector:size	()I
    //   17: if_icmpge +89 -> 106
    //   20: aload_0
    //   21: getfield 109	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   24: iload_3
    //   25: invokevirtual 661	java/util/Vector:get	(I)Ljava/lang/Object;
    //   28: checkcast 191	java/lang/ref/WeakReference
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +51 -> 84
    //   36: aload_1
    //   37: invokevirtual 423	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   40: checkcast 6	com/tencent/image/URLState$Callback
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +13 -> 58
    //   48: aload_1
    //   49: aload_0
    //   50: invokeinterface 693 2 0
    //   55: goto +58 -> 113
    //   58: aload_0
    //   59: getfield 109	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   62: astore_1
    //   63: iload_3
    //   64: iconst_1
    //   65: isub
    //   66: istore 4
    //   68: aload_1
    //   69: iload_3
    //   70: invokevirtual 666	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   73: pop
    //   74: iload 4
    //   76: istore_3
    //   77: goto +36 -> 113
    //   80: aload_2
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_0
    //   85: getfield 109	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   88: astore_1
    //   89: iload_3
    //   90: iconst_1
    //   91: isub
    //   92: istore 4
    //   94: aload_1
    //   95: iload_3
    //   96: invokevirtual 666	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   99: pop
    //   100: iload 4
    //   102: istore_3
    //   103: goto +10 -> 113
    //   106: aload_2
    //   107: monitorexit
    //   108: return
    //   109: astore_1
    //   110: goto -30 -> 80
    //   113: iload_3
    //   114: iconst_1
    //   115: iadd
    //   116: istore_3
    //   117: goto -108 -> 9
    //   120: astore_1
    //   121: goto -41 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	URLState
    //   31	64	1	localObject1	Object
    //   109	1	1	localObject2	Object
    //   120	1	1	localObject3	Object
    //   4	103	2	localVector	Vector
    //   8	109	3	i	int
    //   66	35	4	j	int
    // Exception table:
    //   from	to	target	type
    //   9	32	109	finally
    //   36	44	109	finally
    //   48	55	109	finally
    //   58	63	109	finally
    //   84	89	109	finally
    //   106	108	109	finally
    //   68	74	120	finally
    //   80	82	120	finally
    //   94	100	120	finally
  }
  
  void onLoadSuccessed(Object paramObject)
  {
    if (this.mIsLoadingStarted == 0) {
      return;
    }
    paramObject = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          Object localObject1 = (WeakReference)this.callbacks.get(i);
          if (localObject1 != null)
          {
            localObject1 = (Callback)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((Callback)localObject1).onLoadSuccessed(this);
            }
          }
        }
        else
        {
          this.callbacks.clear();
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  void onResult(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_", 2, "URLState.onResult " + paramObject + " " + this.mUrlStr);
    }
    if (paramObject == FILE_DOWNLOADED)
    {
      onFileDownloaded();
      return;
    }
    if ((paramObject instanceof PendingIntent.CanceledException))
    {
      onLoadCancelled();
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      onLoadFailed((Throwable)paramObject);
      return;
    }
    onLoadSuccessed(paramObject);
  }
  
  boolean reStartDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    if ((this.mStatus != 2) && (this.mStatus != 3)) {
      return false;
    }
    this.mIsLoadingStarted = 0;
    this.mStatus = 0;
    startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramFloat, paramBoolean5, paramObject2);
    return true;
  }
  
  void removeCallBack(Callback paramCallback)
  {
    Vector localVector = this.callbacks;
    int i = 0;
    try
    {
      if (i >= this.callbacks.size()) {
        break label119;
      }
      localObject = (WeakReference)this.callbacks.get(i);
      if (localObject == null) {
        break label90;
      }
      localObject = (Callback)((WeakReference)localObject).get();
      if (localObject == null) {
        break label129;
      }
      if (localObject == paramCallback) {}
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int j;
        continue;
        do
        {
          break;
        } while (localObject != null);
      }
    }
    localObject = this.callbacks;
    j = i - 1;
    for (;;)
    {
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        label90:
        continue;
      }
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
    }
    throw paramCallback;
    label119:
  }
  
  public String saveTo(String paramString)
    throws IOException
  {
    if (this.mCacheFile == null) {
      throw new FileNotFoundException("File is not download complete, please check getStatus() == URLDrawable.SUCCESSED first. ");
    }
    File localFile = this.mCacheFile;
    String str = paramString;
    if (paramString.indexOf(".") == -1) {
      if (!(this.mSuccessed instanceof GifDrawable.GifState)) {
        break label87;
      }
    }
    label87:
    for (str = ".gif";; str = ".jpg")
    {
      str = paramString + str;
      Utils.copyFile(localFile, new File(str));
      if (localFile == null) {
        break;
      }
      return str;
    }
    return null;
  }
  
  void startDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    if (this.mProtocolDownloader == null) {
      onLoadFailed(new NullPointerException("mProtocolDownloader is null"));
    }
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawable_", 2, "URLState.startDownload:" + this.mUrlStr + " isLoadingStarted:" + this.mIsLoadingStarted);
        }
        if (this.mIsLoadingStarted == 0)
        {
          this.mIsLoadingStarted += 1;
          this.mDecodeFile = paramBoolean1;
          this.mParams.cookies = paramCookieStore;
          this.mParams.headers = paramArrayOfHeader;
          this.mParams.tag = paramObject1;
          this.mParams.useGifAnimation = paramBoolean2;
          this.mParams.useApngImage = paramBoolean3;
          this.mParams.useSharpPImage = paramBoolean4;
          this.mParams.mGifRoundCorner = paramFloat;
          this.mParams.useExifOrientation = paramBoolean5;
          this.mParams.mExtraInfo = paramObject2;
          paramArrayOfHeader = new PreDownloadRunnable(this.mUrl);
          URLDrawable.sDefaultDrawableParms.mSubHandler.post(paramArrayOfHeader);
          this.mTask = paramArrayOfHeader;
          return;
        }
        if ((this.mDecodeFile) || (!paramBoolean1)) {
          break;
        }
        synchronized (this.mDecodeFileLock)
        {
          if (this.mStatus == 0)
          {
            this.mDecodeFile = true;
            return;
          }
        }
      } while (this.mIsLoadingStarted != 0);
      startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramFloat, paramBoolean5, paramObject2);
      return;
    } while ((this.mIsLoadingStarted <= 1) || (!QLog.isColorLevel()));
    QLog.i("URLDrawable_", 2, "startDownload mIsLoadingStarted is " + this.mIsLoadingStarted);
  }
  
  String wrapLog(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append('\n');
    paramString.append("  |- URLState:");
    paramString.append(this);
    paramString.append('\n');
    paramString.append("  |- url:");
    paramString.append(this.mUrlStr);
    paramString.append('\n');
    paramString.append("  |- callbacks:");
    paramString.append(this.callbacks.size());
    return paramString.toString();
  }
  
  public static abstract interface Callback
  {
    public abstract void onFileDownloadFailed(int paramInt);
    
    public abstract void onFileDownloadStarted();
    
    public abstract void onFileDownloadSucceed(long paramLong);
    
    public abstract void onFileDownloaded(URLState paramURLState);
    
    public abstract void onLoadCanceled(URLState paramURLState);
    
    public abstract void onLoadFailed(URLState paramURLState, Throwable paramThrowable);
    
    public abstract void onLoadStarted(URLState paramURLState);
    
    public abstract void onLoadSuccessed(URLState paramURLState);
    
    public abstract void onUpdateProgress(int paramInt);
  }
  
  class DownloadRunnable
    implements Runnable, URLDrawableHandler
  {
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    URL mUrl;
    
    DownloadRunnable(URL paramURL)
    {
      this.mUrl = paramURL;
    }
    
    private void result(final Object paramObject)
    {
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          URLState.this.onResult(paramObject);
        }
      });
    }
    
    public void cancel()
    {
      this.mCancelled.set(true);
    }
    
    public void doCancel()
    {
      throw new CancellationException();
    }
    
    public boolean isCancelled()
    {
      return this.mCancelled.get();
    }
    
    /* Error */
    public void onFileDownloadFailed(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore_3
      //   8: aload_3
      //   9: monitorenter
      //   10: iconst_0
      //   11: istore 4
      //   13: iload 4
      //   15: aload_0
      //   16: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   19: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   22: invokevirtual 77	java/util/Vector:size	()I
      //   25: if_icmpge +105 -> 130
      //   28: aload_0
      //   29: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   32: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   35: iload 4
      //   37: invokevirtual 80	java/util/Vector:get	(I)Ljava/lang/Object;
      //   40: checkcast 82	java/lang/ref/WeakReference
      //   43: astore_2
      //   44: aload_2
      //   45: ifnull +57 -> 102
      //   48: aload_2
      //   49: invokevirtual 85	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   52: checkcast 87	com/tencent/image/URLState$Callback
      //   55: astore_2
      //   56: aload_2
      //   57: ifnull +13 -> 70
      //   60: aload_2
      //   61: iload_1
      //   62: invokeinterface 89 2 0
      //   67: goto +70 -> 137
      //   70: aload_0
      //   71: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   74: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   77: astore_2
      //   78: iload 4
      //   80: iconst_1
      //   81: isub
      //   82: istore 5
      //   84: aload_2
      //   85: iload 4
      //   87: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   90: pop
      //   91: iload 5
      //   93: istore 4
      //   95: goto +42 -> 137
      //   98: aload_3
      //   99: monitorexit
      //   100: aload_2
      //   101: athrow
      //   102: aload_0
      //   103: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   106: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   109: astore_2
      //   110: iload 4
      //   112: iconst_1
      //   113: isub
      //   114: istore 5
      //   116: aload_2
      //   117: iload 4
      //   119: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   122: pop
      //   123: iload 5
      //   125: istore 4
      //   127: goto +10 -> 137
      //   130: aload_3
      //   131: monitorexit
      //   132: return
      //   133: astore_2
      //   134: goto -36 -> 98
      //   137: iload 4
      //   139: iconst_1
      //   140: iadd
      //   141: istore 4
      //   143: goto -130 -> 13
      //   146: astore_2
      //   147: goto -49 -> 98
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	150	0	this	DownloadRunnable
      //   0	150	1	paramInt	int
      //   43	74	2	localObject1	Object
      //   133	1	2	localObject2	Object
      //   146	1	2	localObject3	Object
      //   7	124	3	localVector	Vector
      //   11	131	4	i	int
      //   82	42	5	j	int
      // Exception table:
      //   from	to	target	type
      //   13	44	133	finally
      //   48	56	133	finally
      //   60	67	133	finally
      //   70	78	133	finally
      //   102	110	133	finally
      //   130	132	133	finally
      //   84	91	146	finally
      //   98	100	146	finally
      //   116	123	146	finally
    }
    
    /* Error */
    public void onFileDownloadStarted()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore_2
      //   8: aload_2
      //   9: monitorenter
      //   10: iconst_0
      //   11: istore_3
      //   12: iload_3
      //   13: aload_0
      //   14: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   17: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   20: invokevirtual 77	java/util/Vector:size	()I
      //   23: if_icmpge +97 -> 120
      //   26: aload_0
      //   27: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   30: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   33: iload_3
      //   34: invokevirtual 80	java/util/Vector:get	(I)Ljava/lang/Object;
      //   37: checkcast 82	java/lang/ref/WeakReference
      //   40: astore_1
      //   41: aload_1
      //   42: ifnull +53 -> 95
      //   45: aload_1
      //   46: invokevirtual 85	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   49: checkcast 87	com/tencent/image/URLState$Callback
      //   52: astore_1
      //   53: aload_1
      //   54: ifnull +12 -> 66
      //   57: aload_1
      //   58: invokeinterface 95 1 0
      //   63: goto +64 -> 127
      //   66: aload_0
      //   67: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   70: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   73: astore_1
      //   74: iload_3
      //   75: iconst_1
      //   76: isub
      //   77: istore 4
      //   79: aload_1
      //   80: iload_3
      //   81: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   84: pop
      //   85: iload 4
      //   87: istore_3
      //   88: goto +39 -> 127
      //   91: aload_2
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      //   95: aload_0
      //   96: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   99: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   102: astore_1
      //   103: iload_3
      //   104: iconst_1
      //   105: isub
      //   106: istore 4
      //   108: aload_1
      //   109: iload_3
      //   110: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   113: pop
      //   114: iload 4
      //   116: istore_3
      //   117: goto +10 -> 127
      //   120: aload_2
      //   121: monitorexit
      //   122: return
      //   123: astore_1
      //   124: goto -33 -> 91
      //   127: iload_3
      //   128: iconst_1
      //   129: iadd
      //   130: istore_3
      //   131: goto -119 -> 12
      //   134: astore_1
      //   135: goto -44 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	138	0	this	DownloadRunnable
      //   40	69	1	localObject1	Object
      //   123	1	1	localObject2	Object
      //   134	1	1	localObject3	Object
      //   7	114	2	localVector	Vector
      //   11	120	3	i	int
      //   77	38	4	j	int
      // Exception table:
      //   from	to	target	type
      //   12	41	123	finally
      //   45	53	123	finally
      //   57	63	123	finally
      //   66	74	123	finally
      //   95	103	123	finally
      //   120	122	123	finally
      //   79	85	134	finally
      //   91	93	134	finally
      //   108	114	134	finally
    }
    
    /* Error */
    public void onFileDownloadSucceed(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore 4
      //   9: aload 4
      //   11: monitorenter
      //   12: iconst_0
      //   13: istore 5
      //   15: iload 5
      //   17: aload_0
      //   18: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   21: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   24: invokevirtual 77	java/util/Vector:size	()I
      //   27: if_icmpge +106 -> 133
      //   30: aload_0
      //   31: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   34: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   37: iload 5
      //   39: invokevirtual 80	java/util/Vector:get	(I)Ljava/lang/Object;
      //   42: checkcast 82	java/lang/ref/WeakReference
      //   45: astore_3
      //   46: aload_3
      //   47: ifnull +58 -> 105
      //   50: aload_3
      //   51: invokevirtual 85	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   54: checkcast 87	com/tencent/image/URLState$Callback
      //   57: astore_3
      //   58: aload_3
      //   59: ifnull +13 -> 72
      //   62: aload_3
      //   63: lload_1
      //   64: invokeinterface 99 3 0
      //   69: goto +72 -> 141
      //   72: aload_0
      //   73: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   76: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   79: astore_3
      //   80: iload 5
      //   82: iconst_1
      //   83: isub
      //   84: istore 6
      //   86: aload_3
      //   87: iload 5
      //   89: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   92: pop
      //   93: iload 6
      //   95: istore 5
      //   97: goto +44 -> 141
      //   100: aload 4
      //   102: monitorexit
      //   103: aload_3
      //   104: athrow
      //   105: aload_0
      //   106: getfield 25	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   109: invokestatic 71	com/tencent/image/URLState:access$200	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   112: astore_3
      //   113: iload 5
      //   115: iconst_1
      //   116: isub
      //   117: istore 6
      //   119: aload_3
      //   120: iload 5
      //   122: invokevirtual 92	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   125: pop
      //   126: iload 6
      //   128: istore 5
      //   130: goto +11 -> 141
      //   133: aload 4
      //   135: monitorexit
      //   136: return
      //   137: astore_3
      //   138: goto -38 -> 100
      //   141: iload 5
      //   143: iconst_1
      //   144: iadd
      //   145: istore 5
      //   147: goto -132 -> 15
      //   150: astore_3
      //   151: goto -51 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	154	0	this	DownloadRunnable
      //   0	154	1	paramLong	long
      //   45	75	3	localObject1	Object
      //   137	1	3	localObject2	Object
      //   150	1	3	localObject3	Object
      //   7	127	4	localVector	Vector
      //   13	133	5	i	int
      //   84	43	6	j	int
      // Exception table:
      //   from	to	target	type
      //   15	46	137	finally
      //   50	58	137	finally
      //   62	69	137	finally
      //   72	80	137	finally
      //   105	113	137	finally
      //   133	136	137	finally
      //   86	93	150	finally
      //   100	103	150	finally
      //   119	126	150	finally
    }
    
    protected void onProgressUpdate(int paramInt)
    {
      URLState.this.mProgress = paramInt;
      Vector localVector;
      int i;
      if ((!URLDrawable.sPause) || (URLState.this.mIgnorePause))
      {
        localVector = URLState.this.callbacks;
        i = 0;
      }
      for (;;)
      {
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            localObject1 = (WeakReference)URLState.this.callbacks.get(i);
            if (localObject1 != null)
            {
              localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
              if (localObject1 != null)
              {
                ((URLState.Callback)localObject1).onUpdateProgress(paramInt);
                continue;
              }
              localObject1 = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally
        {
          Object localObject1;
          int j;
          continue;
          i += 1;
        }
        try
        {
          ((Vector)localObject1).remove(i);
          i = j;
        }
        finally
        {
          continue;
        }
        throw ((Throwable)localObject1);
        localObject1 = URLState.this.callbacks;
        j = i - 1;
        ((Vector)localObject1).remove(i);
        i = j;
        continue;
        return;
      }
    }
    
    public void publishProgress(final int paramInt)
    {
      if (paramInt == URLState.this.mProgress) {
        return;
      }
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          URLState.DownloadRunnable.this.onProgressUpdate(paramInt);
        }
      });
    }
    
    public void run()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawable_", 2, "DownloadAsyncTask.doInBackground:" + URLState.this.mUrlStr + " isCancelled:" + isCancelled());
        }
        if (isCancelled()) {
          URLState.this.onLoadCancelled();
        }
        result(URLState.this.loadImage(this.mUrl, this));
        return;
      }
      catch (Throwable localThrowable)
      {
        result(localThrowable);
      }
    }
  }
  
  private class PostOnResult
    implements Runnable
  {
    Object result;
    
    public PostOnResult(Object paramObject)
    {
      this.result = paramObject;
    }
    
    public void run()
    {
      URLState.this.onResult(this.result);
    }
  }
  
  class PreDownloadRunnable
    implements Runnable
  {
    private static final int DOWNLOAD_THREAD_POOL = 1;
    private static final int LOCAL_THREAD_POOL = 0;
    boolean hasFile = false;
    URLState.DownloadRunnable mDownloadRunnable;
    private URL url;
    
    PreDownloadRunnable(URL paramURL)
    {
      this.url = paramURL;
      this.mDownloadRunnable = new URLState.DownloadRunnable(URLState.this, paramURL);
    }
    
    public void run()
    {
      if ((Build.VERSION.SDK_INT >= 11) && (URLState.this.mProtocolDownloader != null) && (URLState.this.mProtocolDownloader.hasDiskFile(URLState.this.mParams))) {
        this.hasFile = true;
      }
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          if (QLog.isColorLevel()) {
            QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask doInBackground." + URLState.PreDownloadRunnable.this.url);
          }
          if (URLState.PreDownloadRunnable.this.mDownloadRunnable.isCancelled()) {
            return;
          }
          if (URLState.PreDownloadRunnable.this.hasFile) {
            URLDrawable.sDefaultDrawableParms.mFileHandler.post(URLState.PreDownloadRunnable.this.mDownloadRunnable);
          }
          for (;;)
          {
            URLState.this.onLoadStart();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask onLoadStart." + URLState.PreDownloadRunnable.this.url);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("URLDrawable_", 2, "schedule load image " + URLState.this.mUrlStr);
            }
            URLDrawable.sDefaultDrawableParms.mURLDrawableExecutor.execute(URLState.PreDownloadRunnable.this.mDownloadRunnable);
          }
        }
      });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\URLState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */