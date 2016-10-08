package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MediaPlayerHelper
{
  private static MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  
  private MediaPlayerHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static MediaPlayerHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper == null) {
      jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = new MediaPlayerHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 30	android/media/MediaPlayer:getCurrentPosition	()I
    //   24: istore_2
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   28	4	1	localObject	Object
    //   12	13	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 33	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: invokevirtual 36	android/media/MediaPlayer:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 47	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_2
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 50	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   8	2	1	localMediaPlayer	MediaPlayer
    //   29	2	1	localIllegalStateException	IllegalStateException
    //   37	4	1	localObject	Object
    //   1	25	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  public boolean a(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramContext, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        bool = true;
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        paramContext = new File(paramContext.getFilesDir(), paramString);
        bool2 = paramContext.exists();
        if (bool2) {
          break label73;
        }
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool1;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      continue;
      label73:
      paramContext = new FileInputStream(paramContext.getAbsolutePath());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramContext.getFD());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      paramContext.close();
      bool1 = true;
    }
  }
  
  /* Error */
  public boolean a(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +9 -> 19
    //   13: iload_3
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   23: iload_1
    //   24: invokevirtual 113	android/media/MediaPlayer:setLooping	(Z)V
    //   27: iconst_1
    //   28: istore_1
    //   29: goto -14 -> 15
    //   32: astore_2
    //   33: aload_2
    //   34: invokevirtual 50	java/lang/IllegalStateException:printStackTrace	()V
    //   37: iload_3
    //   38: istore_1
    //   39: goto -24 -> 15
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	MediaPlayerHelper
    //   0	47	1	paramBoolean	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   32	2	2	localIllegalStateException	IllegalStateException
    //   42	4	2	localObject	Object
    //   1	37	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   19	27	32	java/lang/IllegalStateException
    //   4	9	42	finally
    //   19	27	42	finally
    //   33	37	42	finally
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 117	android/media/MediaPlayer:getDuration	()I
    //   24: istore_2
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   28	4	1	localObject	Object
    //   12	13	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 33	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_2
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 50	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   8	2	1	localMediaPlayer	MediaPlayer
    //   29	2	1	localIllegalStateException	IllegalStateException
    //   37	4	1	localObject	Object
    //   1	25	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 121	android/media/MediaPlayer:pause	()V
    //   24: iconst_1
    //   25: istore_2
    //   26: goto -13 -> 13
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 50	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   8	2	1	localMediaPlayer	MediaPlayer
    //   29	2	1	localIllegalStateException	IllegalStateException
    //   37	4	1	localObject	Object
    //   1	25	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 25	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 125	android/media/MediaPlayer:isPlaying	()Z
    //   24: istore_2
    //   25: goto -12 -> 13
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   28	4	1	localObject	Object
    //   12	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\MediaPlayerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */