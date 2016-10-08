package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedDiskCache
{
  private static final Class<?> TAG = BufferedDiskCache.class;
  private final FileCache mFileCache;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final PooledByteStreams mPooledByteStreams;
  private final Executor mReadExecutor;
  private final StagingArea mStagingArea;
  private final Executor mWriteExecutor;
  
  public BufferedDiskCache(FileCache paramFileCache, PooledByteBufferFactory paramPooledByteBufferFactory, PooledByteStreams paramPooledByteStreams, Executor paramExecutor1, Executor paramExecutor2, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    this.mFileCache = paramFileCache;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mPooledByteStreams = paramPooledByteStreams;
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
    this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
    this.mStagingArea = StagingArea.getInstance();
  }
  
  /* Error */
  private com.facebook.imagepipeline.memory.PooledByteBuffer readFromDiskCache(CacheKey paramCacheKey)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   3: ldc 88
    //   5: aload_1
    //   6: invokeinterface 94 1 0
    //   11: invokestatic 100	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 43	com/facebook/imagepipeline/cache/BufferedDiskCache:mFileCache	Lcom/facebook/cache/disk/FileCache;
    //   18: aload_1
    //   19: invokeinterface 106 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +28 -> 54
    //   29: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   32: ldc 108
    //   34: aload_1
    //   35: invokeinterface 94 1 0
    //   40: invokestatic 100	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   47: invokeinterface 113 1 0
    //   52: aconst_null
    //   53: areturn
    //   54: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   57: ldc 115
    //   59: aload_1
    //   60: invokeinterface 94 1 0
    //   65: invokestatic 100	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   72: invokeinterface 118 1 0
    //   77: aload_3
    //   78: invokeinterface 124 1 0
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 45	com/facebook/imagepipeline/cache/BufferedDiskCache:mPooledByteBufferFactory	Lcom/facebook/imagepipeline/memory/PooledByteBufferFactory;
    //   88: aload_2
    //   89: aload_3
    //   90: invokeinterface 128 1 0
    //   95: l2i
    //   96: invokeinterface 134 3 0
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 139	java/io/InputStream:close	()V
    //   106: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   109: ldc -115
    //   111: aload_1
    //   112: invokeinterface 94 1 0
    //   117: invokestatic 100	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: getstatic 36	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   126: aload_2
    //   127: ldc -113
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: invokeinterface 94 1 0
    //   141: aastore
    //   142: invokestatic 147	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 53	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   149: invokeinterface 150 1 0
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_2
    //   158: invokevirtual 139	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	BufferedDiskCache
    //   0	163	1	paramCacheKey	CacheKey
    //   83	20	2	localInputStream	java.io.InputStream
    //   122	36	2	localIOException	IOException
    //   24	97	3	localObject1	Object
    //   156	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	25	122	java/io/IOException
    //   29	52	122	java/io/IOException
    //   54	84	122	java/io/IOException
    //   102	120	122	java/io/IOException
    //   157	163	122	java/io/IOException
    //   84	102	156	finally
  }
  
  private void writeToDiskCache(CacheKey paramCacheKey, final EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "About to write to disk-cache for key %s", paramCacheKey.toString());
    try
    {
      this.mFileCache.insert(paramCacheKey, new WriterCallback()
      {
        public void write(OutputStream paramAnonymousOutputStream)
          throws IOException
        {
          BufferedDiskCache.this.mPooledByteStreams.copy(paramEncodedImage.getInputStream(), paramAnonymousOutputStream);
        }
      });
      FLog.v(TAG, "Successful disk-cache write for key %s", paramCacheKey.toString());
      return;
    }
    catch (IOException paramEncodedImage)
    {
      FLog.w(TAG, paramEncodedImage, "Failed to write to disk-cache for key %s", new Object[] { paramCacheKey.toString() });
    }
  }
  
  public Task<Void> clearAll()
  {
    this.mStagingArea.clearAll();
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.clearAll();
          BufferedDiskCache.this.mFileCache.clearAll();
          return null;
        }
      }, this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache clear", new Object[0]);
      return Task.forError(localException);
    }
  }
  
  public Task<Boolean> contains(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Object localObject = this.mStagingArea.get(paramCacheKey);
    if (localObject != null)
    {
      ((EncodedImage)localObject).close();
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.toString());
      this.mImageCacheStatsTracker.onStagingAreaHit();
      return Task.forResult(Boolean.valueOf(true));
    }
    try
    {
      localObject = Task.call(new Callable()
      {
        public Boolean call()
          throws Exception
        {
          EncodedImage localEncodedImage = BufferedDiskCache.this.mStagingArea.get(paramCacheKey);
          if (localEncodedImage != null)
          {
            localEncodedImage.close();
            FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", paramCacheKey.toString());
            BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit();
            return Boolean.valueOf(true);
          }
          FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", paramCacheKey.toString());
          BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss();
          try
          {
            boolean bool = BufferedDiskCache.this.mFileCache.hasKey(paramCacheKey);
            return Boolean.valueOf(bool);
          }
          catch (Exception localException) {}
          return Boolean.valueOf(false);
        }
      }, this.mReadExecutor);
      return (Task<Boolean>)localObject;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.toString() });
      return Task.forError(localException);
    }
  }
  
  public Task<EncodedImage> get(final CacheKey paramCacheKey, final AtomicBoolean paramAtomicBoolean)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Preconditions.checkNotNull(paramAtomicBoolean);
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
    {
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.toString());
      this.mImageCacheStatsTracker.onStagingAreaHit();
      return Task.forResult(localEncodedImage);
    }
    try
    {
      paramAtomicBoolean = Task.call(new Callable()
      {
        /* Error */
        public EncodedImage call()
          throws Exception
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$isCancelled	Ljava/util/concurrent/atomic/AtomicBoolean;
          //   4: invokevirtual 39	java/util/concurrent/atomic/AtomicBoolean:get	()Z
          //   7: ifeq +11 -> 18
          //   10: new 41	java/util/concurrent/CancellationException
          //   13: dup
          //   14: invokespecial 42	java/util/concurrent/CancellationException:<init>	()V
          //   17: athrow
          //   18: aload_0
          //   19: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   22: invokestatic 46	com/facebook/imagepipeline/cache/BufferedDiskCache:access$0	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/StagingArea;
          //   25: aload_0
          //   26: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   29: invokevirtual 51	com/facebook/imagepipeline/cache/StagingArea:get	(Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/image/EncodedImage;
          //   32: astore_1
          //   33: aload_1
          //   34: ifnull +62 -> 96
          //   37: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$1	()Ljava/lang/Class;
          //   40: ldc 57
          //   42: aload_0
          //   43: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   46: invokeinterface 63 1 0
          //   51: invokestatic 69	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   58: invokestatic 73	com/facebook/imagepipeline/cache/BufferedDiskCache:access$2	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   61: invokeinterface 78 1 0
          //   66: invokestatic 83	java/lang/Thread:interrupted	()Z
          //   69: ifeq +97 -> 166
          //   72: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$1	()Ljava/lang/Class;
          //   75: ldc 85
          //   77: invokestatic 88	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;)V
          //   80: aload_1
          //   81: ifnull +7 -> 88
          //   84: aload_1
          //   85: invokevirtual 93	com/facebook/imagepipeline/image/EncodedImage:close	()V
          //   88: new 95	java/lang/InterruptedException
          //   91: dup
          //   92: invokespecial 96	java/lang/InterruptedException:<init>	()V
          //   95: athrow
          //   96: invokestatic 55	com/facebook/imagepipeline/cache/BufferedDiskCache:access$1	()Ljava/lang/Class;
          //   99: ldc 98
          //   101: aload_0
          //   102: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   105: invokeinterface 63 1 0
          //   110: invokestatic 69	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   113: aload_0
          //   114: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   117: invokestatic 73	com/facebook/imagepipeline/cache/BufferedDiskCache:access$2	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;)Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
          //   120: invokeinterface 101 1 0
          //   125: aload_0
          //   126: getfield 22	com/facebook/imagepipeline/cache/BufferedDiskCache$2:this$0	Lcom/facebook/imagepipeline/cache/BufferedDiskCache;
          //   129: aload_0
          //   130: getfield 26	com/facebook/imagepipeline/cache/BufferedDiskCache$2:val$key	Lcom/facebook/cache/common/CacheKey;
          //   133: invokestatic 105	com/facebook/imagepipeline/cache/BufferedDiskCache:access$4	(Lcom/facebook/imagepipeline/cache/BufferedDiskCache;Lcom/facebook/cache/common/CacheKey;)Lcom/facebook/imagepipeline/memory/PooledByteBuffer;
          //   136: invokestatic 111	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
          //   139: astore_2
          //   140: new 90	com/facebook/imagepipeline/image/EncodedImage
          //   143: dup
          //   144: aload_2
          //   145: invokespecial 114	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
          //   148: astore_1
          //   149: aload_2
          //   150: invokestatic 117	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   153: goto -87 -> 66
          //   156: astore_1
          //   157: aload_2
          //   158: invokestatic 117	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   161: aload_1
          //   162: athrow
          //   163: astore_1
          //   164: aconst_null
          //   165: areturn
          //   166: aload_1
          //   167: areturn
          //   168: astore_1
          //   169: goto -5 -> 164
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	172	0	this	2
          //   32	117	1	localEncodedImage	EncodedImage
          //   156	6	1	localObject	Object
          //   163	4	1	localException1	Exception
          //   168	1	1	localException2	Exception
          //   139	19	2	localCloseableReference	com.facebook.common.references.CloseableReference
          // Exception table:
          //   from	to	target	type
          //   140	149	156	finally
          //   125	140	163	java/lang/Exception
          //   157	163	163	java/lang/Exception
          //   149	153	168	java/lang/Exception
        }
      }, this.mReadExecutor);
      return paramAtomicBoolean;
    }
    catch (Exception paramAtomicBoolean)
    {
      FLog.w(TAG, paramAtomicBoolean, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.toString() });
    }
    return Task.forError(paramAtomicBoolean);
  }
  
  public void put(final CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    Preconditions.checkNotNull(paramCacheKey);
    Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
    this.mStagingArea.put(paramCacheKey, paramEncodedImage);
    final EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
    try
    {
      this.mWriteExecutor.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            BufferedDiskCache.this.writeToDiskCache(paramCacheKey, localEncodedImage);
            return;
          }
          finally
          {
            BufferedDiskCache.this.mStagingArea.remove(paramCacheKey, localEncodedImage);
            EncodedImage.closeSafely(localEncodedImage);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache write for %s", new Object[] { paramCacheKey.toString() });
      this.mStagingArea.remove(paramCacheKey, paramEncodedImage);
      EncodedImage.closeSafely(localEncodedImage);
    }
  }
  
  public Task<Void> remove(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mStagingArea.remove(paramCacheKey);
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          BufferedDiskCache.this.mStagingArea.remove(paramCacheKey);
          BufferedDiskCache.this.mFileCache.remove(paramCacheKey);
          return null;
        }
      }, this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache remove for %s", new Object[] { paramCacheKey.toString() });
      return Task.forError(localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\imagepipeline\cache\BufferedDiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */