package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;

public class DefaultDiskStorageSupplier
  implements DiskStorageSupplier
{
  private static final Class<?> TAG = DefaultDiskStorageSupplier.class;
  private final String mBaseDirectoryName;
  private final Supplier<File> mBaseDirectoryPathSupplier;
  private final CacheErrorLogger mCacheErrorLogger;
  @VisibleForTesting
  volatile State mCurrentState;
  private final int mVersion;
  
  public DefaultDiskStorageSupplier(int paramInt, Supplier<File> paramSupplier, String paramString, CacheErrorLogger paramCacheErrorLogger)
  {
    this.mVersion = paramInt;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mBaseDirectoryPathSupplier = paramSupplier;
    this.mBaseDirectoryName = paramString;
    this.mCurrentState = new State(null, null);
  }
  
  private void createStorage()
    throws IOException
  {
    File localFile = new File((File)this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
    createRootDirectoryIfNecessary(localFile);
    this.mCurrentState = new State(localFile, new DefaultDiskStorage(localFile, this.mVersion, this.mCacheErrorLogger));
  }
  
  private boolean shouldCreateNewStorage()
  {
    State localState = this.mCurrentState;
    return (localState.storage == null) || (localState.rootDirectory == null) || (!localState.rootDirectory.exists());
  }
  
  @VisibleForTesting
  void createRootDirectoryIfNecessary(File paramFile)
    throws IOException
  {
    try
    {
      FileUtils.mkdirs(paramFile);
      FLog.d(TAG, "Created cache directory %s", paramFile.getAbsolutePath());
      return;
    }
    catch (FileUtils.CreateDirectoryException paramFile)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", paramFile);
      throw paramFile;
    }
  }
  
  @VisibleForTesting
  void deleteOldStorageIfNecessary()
  {
    if ((this.mCurrentState.storage != null) && (this.mCurrentState.rootDirectory != null)) {
      FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }
  }
  
  public DiskStorage get()
    throws IOException
  {
    try
    {
      if (shouldCreateNewStorage())
      {
        deleteOldStorageIfNecessary();
        createStorage();
      }
      DiskStorage localDiskStorage = (DiskStorage)Preconditions.checkNotNull(this.mCurrentState.storage);
      return localDiskStorage;
    }
    finally {}
  }
  
  @VisibleForTesting
  static class State
  {
    @Nullable
    public final File rootDirectory;
    @Nullable
    public final DiskStorage storage;
    
    @VisibleForTesting
    State(@Nullable File paramFile, @Nullable DiskStorage paramDiskStorage)
    {
      this.storage = paramDiskStorage;
      this.rootDirectory = paramFile;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\cache\disk\DefaultDiskStorageSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */