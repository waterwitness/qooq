package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TbsInstaller
{
  private static final String APK_FOLDER = "tbs_apk";
  static final String APP_DEMO = "com.tencent.x5sdk.demo";
  static final String APP_DEMO_TEST = "com.tencent.mtt.sdk.test";
  static final String APP_QB = "com.tencent.mtt";
  static final String APP_QQ = "com.tencent.mobileqq";
  static final String APP_QQPIMSECURE = "com.tencent.qqpimsecure";
  static final String APP_QZONE = "com.qzone";
  static final String APP_WX = "com.tencent.mm";
  static final int COPY_STATUS_FAIL = 2;
  static final int COPY_STATUS_START = 0;
  static final int COPY_STATUS_SUCCESS = 1;
  static final int COPY_STATUS_UNKNOWN = -1;
  static final int COPY_STATUS_WILLUSE = 3;
  private static final String DEFAULT_MAX_SUPPORTED_API_LEVEL = "23";
  private static final String DEFAULT_MIN_SUPPORTED_API_LEVEL = "8";
  private static final String DEMO_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  static final int INCRUPDATE_STATUS_PATCH_SUCCESS = 1;
  static final int INCRUPDATE_STATUS_UNKNOW = -1;
  static final int INSTALL_STATUS_CANNOTUSE = 5;
  static final int INSTALL_STATUS_DEXOPT = 1;
  static final int INSTALL_STATUS_RENAME = 2;
  static final int INSTALL_STATUS_UNKNOWN = -1;
  static final int INSTALL_STATUS_UNZIP = 0;
  static final int INSTALL_STATUS_USING = 4;
  static final int INSTALL_STATUS_WILLUSE = 3;
  static final String KEY_DIFF_FILE_LOCATION = "diff_file_location";
  static final String KEY_NEW_APK_LOCATION = "new_apk_location";
  static final String KEY_NEW_CORE_VERSION = "new_core_ver";
  static final String KEY_OLD_APK_LOCATION = "old_apk_location";
  static final String KEY_OLD_CORE_VERSION = "old_core_ver";
  static final String KEY_OPERATION = "operation";
  private static final String KEY_PATCH_APK_PATH = "apk_path";
  private static final String KEY_PATCH_RESULT = "patch_result";
  private static final String KEY_PATCH_TBSCORE_VER = "tbs_core_ver";
  private static final String LAST_APP_ID_FOR_STATIC_TBS = "last_app_id_for_static_tbs";
  private static final String MD5_FILE = "1";
  private static final String MM_SIG = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
  private static final String MOBILEQQ_SIG = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
  private static final int MSG_COPY_TBS_CORE = 2;
  private static final int MSG_INSTALL_TBS_CORE = 1;
  private static final int MSG_INSTALL_TBS_CORE_EX = 3;
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final int OP_CONTINUE_PATCH = 10001;
  private static final int PATCH_FAIL = 1;
  private static final int PATCH_LOAD_ERROR = 3;
  private static final int PATCH_NONEEDPATCH = 2;
  private static final int PATCH_SUCCESS = 0;
  private static final String QQPIMSECURE_SIG = "30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8";
  private static final String QZONE_SIG = "308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677";
  private static final int RETRY_NUM_COPY = 10;
  private static final int RETRY_NUM_DEXOPT = 10;
  private static final int RETRY_NUM_UNZIP = 10;
  private static final int STATIC_TBS_CORE_SIZE = 10240;
  static final String STATIC_TBS_INSTALLATION_CONF = "static_tbs_installation_conf";
  private static final int STATIC_TBS_INSTALLATION_MAX_TRY_TIMES = 6;
  private static final String STATIC_TBS_INSTALLATION_TRIED_APPID = "static_tbs_installation_tried_appid";
  private static final String STATIC_TBS_INSTALLATION_TRIED_TIMES = "static_tbs_installation_tried_times";
  private static final String TAG = "TbsInstaller";
  private static final String TBS_CONF = "tbs.conf";
  private static final String TBS_CONF_TIMESTAMP = "tbs_core_build_number";
  private static final String TBS_CORE_VER = "tbs_core_version";
  static final String TBS_EXTENSION_CFG_FILE = "tbs_extension.conf";
  private static final String TBS_FILE_APK = "tbs.apk";
  private static final String TBS_FILE_CONF = "tbs.conf";
  static final String TBS_FOLDER_NAME = "tbs";
  private static final String TBS_LOCAL_INSTALLATION = "tbs_local_installation";
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  static final String TBS_SHARE_FOLDER_NAME = "core_share";
  static final String TBS_SHARE_NAME = "share";
  private static final String TBS_STATIC_FILE_LIBRARY_PATTERN = "libtbs\\.(.*)\\.so";
  private static final int TMP_COPY_TBS_INSTALLATION = 1;
  private static final int TMP_DOWNLOAD_TBS_INSTALLATION = 0;
  private static final int TMP_STATIC_TBS_INSTALLATION = 2;
  static final String TMP_TBS_COPY_FOLDER_NAME = "core_copy_tmp";
  private static final String TMP_TBS_STATIC_FOLDER_NAME = "core_static_tbs_tmp";
  static final String TMP_TBS_UNZIP_FOLDER_NAME = "core_unzip_tmp";
  private static final String WEBCORE_LIB_FILENAME = "libmttwebcore.so";
  private static final Long[][] WEBCORE_LIB_LENGTH_MAP;
  private static boolean isQuickDexOptForThirdPartyAppCalled = false;
  static boolean isStaticTbsInstalling;
  private static TbsInstaller mInstance = null;
  private static final Lock mTbsInstallLock;
  private static Handler mTbsInstallerHandler;
  private static final Lock mTbsRenameLock = new ReentrantLock();
  int mTbsCoreInstalledVer = 0;
  
  static
  {
    mTbsInstallLock = new ReentrantLock();
    mTbsInstallerHandler = null;
    WEBCORE_LIB_LENGTH_MAP = new Long[][] { { Long.valueOf(25413L), Long.valueOf(11460320L) }, { Long.valueOf(25436L), Long.valueOf(12009376L) }, { Long.valueOf(25437L), Long.valueOf(11489180L) }, { Long.valueOf(25438L), Long.valueOf(11489180L) }, { Long.valueOf(25439L), Long.valueOf(12013472L) }, { Long.valueOf(25440L), Long.valueOf(11489180L) }, { Long.valueOf(25442L), Long.valueOf(11489180L) } };
    isStaticTbsInstalling = false;
  }
  
  private TbsInstaller()
  {
    if (mTbsInstallerHandler == null) {
      mTbsInstallerHandler = new Handler(TbsHandlerThread.getInstance().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            super.handleMessage(paramAnonymousMessage);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installTbsCoreInThread((Context)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.copyTbsCoreInThread((Context)arrayOfObject[0], (Context)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installLocalTbsCoreExInThread((Context)arrayOfObject[0], (Bundle)arrayOfObject[1]);
          }
        }
      };
    }
  }
  
  private void cleanStatusAndTmpDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
    TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, -1);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
    FileUtil.delete(getTmpTbsCoreUnzipDir(paramContext), true);
    FileUtil.delete(getTmpTbsCoreCopyDir(paramContext), true);
  }
  
  private void clearNewTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = getTmpTbsCoreUnzipDir(paramContext);
    if (localFile != null) {
      FileUtil.delete(localFile, false);
    }
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 5);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
    QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  private void copyApkFromAssets(Context paramContext, String paramString, File paramFile)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssets");
    copyAssetsFileTo(paramContext, paramString, paramFile);
  }
  
  private void copyApkFromAssetsIfNeeded(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssetsIfNeeded");
    File localFile = new File(paramContext.getDir("tbs_apk", 0), "tbs.apk");
    if (localFile.exists()) {
      return;
    }
    copyApkFromAssets(paramContext, "tbs.apk", localFile);
  }
  
  /* Error */
  private void copyAssetsFileTo(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc -111
    //   5: new 383	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 386
    //   15: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_2
    //   19: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 398	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_2
    //   33: invokevirtual 404	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: new 406	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 409	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: ldc_w 410
    //   49: newarray <illegal type>
    //   51: astore_2
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 416	java/io/InputStream:read	([B)I
    //   57: istore 5
    //   59: iload 5
    //   61: iconst_m1
    //   62: if_icmpeq +44 -> 106
    //   65: aload_3
    //   66: aload_2
    //   67: iconst_0
    //   68: iload 5
    //   70: invokevirtual 420	java/io/FileOutputStream:write	([BII)V
    //   73: goto -21 -> 52
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload 4
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 427	java/io/InputStream:close	()V
    //   105: return
    //   106: aload_3
    //   107: invokevirtual 430	java/io/FileOutputStream:flush	()V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: ifnull -14 -> 105
    //   122: aload_1
    //   123: invokevirtual 427	java/io/InputStream:close	()V
    //   126: return
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 426	java/io/FileOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 427	java/io/InputStream:close	()V
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_3
    //   158: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   161: goto -15 -> 146
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   169: goto -15 -> 154
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   177: goto -80 -> 97
    //   180: astore_1
    //   181: goto -53 -> 128
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   189: goto -71 -> 118
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -57 -> 138
    //   198: astore_2
    //   199: goto -61 -> 138
    //   202: astore_3
    //   203: aload_2
    //   204: astore 4
    //   206: aload_3
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: aload 4
    //   212: astore_1
    //   213: goto -75 -> 138
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload 4
    //   221: astore_2
    //   222: goto -137 -> 85
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 4
    //   229: aload_1
    //   230: astore_2
    //   231: aload 4
    //   233: astore_1
    //   234: goto -149 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	TbsInstaller
    //   0	237	1	paramContext	Context
    //   0	237	2	paramString	String
    //   0	237	3	paramFile	File
    //   1	1	4	localObject	Object
    //   76	7	4	localIOException	java.io.IOException
    //   204	28	4	str	String
    //   57	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   46	52	76	java/io/IOException
    //   52	59	76	java/io/IOException
    //   65	73	76	java/io/IOException
    //   106	110	76	java/io/IOException
    //   122	126	127	java/io/IOException
    //   28	37	133	finally
    //   142	146	156	java/io/IOException
    //   150	154	164	java/io/IOException
    //   93	97	172	java/io/IOException
    //   101	105	180	java/io/IOException
    //   114	118	184	java/io/IOException
    //   37	46	192	finally
    //   46	52	198	finally
    //   52	59	198	finally
    //   65	73	198	finally
    //   106	110	198	finally
    //   85	89	202	finally
    //   28	37	216	java/io/IOException
    //   37	46	225	java/io/IOException
  }
  
  /* Error */
  @TargetApi(11)
  private void copyTbsCoreInThread(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 441	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   5: ifeq +4 -> 9
    //   8: return
    //   9: ldc -111
    //   11: ldc_w 443
    //   14: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: getstatic 448	android/os/Build$VERSION:SDK_INT	I
    //   20: bipush 11
    //   22: if_icmplt +60 -> 82
    //   25: aload_2
    //   26: ldc_w 450
    //   29: iconst_4
    //   30: invokevirtual 454	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: astore 4
    //   35: aload 4
    //   37: ldc_w 456
    //   40: iconst_m1
    //   41: invokeinterface 462 3 0
    //   46: iload_3
    //   47: if_icmpne +48 -> 95
    //   50: ldc -111
    //   52: new 383	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 464
    //   62: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_3
    //   66: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc_w 469
    //   72: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: return
    //   82: aload_2
    //   83: ldc_w 450
    //   86: iconst_0
    //   87: invokevirtual 454	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   90: astore 4
    //   92: goto -57 -> 35
    //   95: aload_2
    //   96: iconst_1
    //   97: ldc_w 474
    //   100: invokestatic 478	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull -99 -> 8
    //   110: aload_2
    //   111: aload 8
    //   113: invokestatic 482	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   116: astore 9
    //   118: aload 9
    //   120: ifnull -112 -> 8
    //   123: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   126: invokeinterface 487 1 0
    //   131: ifeq +1346 -> 1477
    //   134: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   137: invokeinterface 490 1 0
    //   142: aload_2
    //   143: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   146: invokevirtual 494	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyVer	()I
    //   149: istore 13
    //   151: aload_2
    //   152: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   155: invokevirtual 497	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyStatus	()I
    //   158: istore 12
    //   160: iload 13
    //   162: iload_3
    //   163: if_icmpne +27 -> 190
    //   166: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   169: invokeinterface 500 1 0
    //   174: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   177: invokeinterface 500 1 0
    //   182: aload 9
    //   184: aload 8
    //   186: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   189: return
    //   190: aload_0
    //   191: aload_2
    //   192: invokevirtual 508	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   195: istore 14
    //   197: ldc -111
    //   199: new 383	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 510
    //   209: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: iload 14
    //   214: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   217: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: iload 14
    //   225: iload_3
    //   226: if_icmpne +22 -> 248
    //   229: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   232: invokeinterface 500 1 0
    //   237: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   240: invokeinterface 500 1 0
    //   245: goto -63 -> 182
    //   248: aload_2
    //   249: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   252: invokevirtual 513	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   255: istore 15
    //   257: iload 15
    //   259: ifle +1283 -> 1542
    //   262: iload_3
    //   263: iload 15
    //   265: if_icmpgt +6 -> 271
    //   268: goto +1274 -> 1542
    //   271: aload_0
    //   272: aload_2
    //   273: invokespecial 515	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   276: goto +1280 -> 1556
    //   279: iconst_m1
    //   280: istore 13
    //   282: aload_0
    //   283: aload_2
    //   284: invokespecial 515	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   287: ldc -111
    //   289: ldc_w 517
    //   292: iconst_1
    //   293: invokestatic 520	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   296: invokestatic 526	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   299: ldc2_w 527
    //   302: aload_0
    //   303: aload_1
    //   304: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   307: invokestatic 535	com/tencent/smtt/utils/TbsUtils:getDirSize	(Ljava/io/File;)J
    //   310: lmul
    //   311: lcmp
    //   312: ifge +83 -> 395
    //   315: invokestatic 526	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   318: lstore 16
    //   320: aload_0
    //   321: aload_1
    //   322: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   325: invokestatic 535	com/tencent/smtt/utils/TbsUtils:getDirSize	(Ljava/io/File;)J
    //   328: lstore 18
    //   330: aload_2
    //   331: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   334: sipush 210
    //   337: new 383	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 542
    //   347: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: lload 16
    //   352: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: ldc_w 547
    //   358: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc2_w 527
    //   364: lload 18
    //   366: lmul
    //   367: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   376: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   379: invokeinterface 500 1 0
    //   384: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   387: invokeinterface 500 1 0
    //   392: goto -210 -> 182
    //   395: iload 13
    //   397: ifle +22 -> 419
    //   400: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   403: invokeinterface 500 1 0
    //   408: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   411: invokeinterface 500 1 0
    //   416: goto -234 -> 182
    //   419: iload 13
    //   421: ifne +62 -> 483
    //   424: aload_2
    //   425: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   428: invokevirtual 554	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreCopyRetryNum	()I
    //   431: istore 12
    //   433: iload 12
    //   435: bipush 10
    //   437: if_icmple +35 -> 472
    //   440: aload_2
    //   441: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   444: sipush 211
    //   447: ldc_w 556
    //   450: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   453: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   456: invokeinterface 500 1 0
    //   461: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   464: invokeinterface 500 1 0
    //   469: goto -287 -> 182
    //   472: aload_2
    //   473: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   476: iload 12
    //   478: iconst_1
    //   479: iadd
    //   480: invokevirtual 322	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyRetryNum	(I)V
    //   483: aload_0
    //   484: aload_1
    //   485: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   488: astore 4
    //   490: aload_0
    //   491: aload_2
    //   492: invokevirtual 341	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreCopyDir	(Landroid/content/Context;)Ljava/io/File;
    //   495: astore 10
    //   497: aload 4
    //   499: ifnull +939 -> 1438
    //   502: aload 10
    //   504: ifnull +934 -> 1438
    //   507: iconst_1
    //   508: invokestatic 560	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   511: aload_2
    //   512: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   515: iload_3
    //   516: iconst_0
    //   517: invokevirtual 325	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   520: new 562	com/tencent/smtt/utils/TbsCopyVerify
    //   523: dup
    //   524: invokespecial 563	com/tencent/smtt/utils/TbsCopyVerify:<init>	()V
    //   527: astore 5
    //   529: aload 5
    //   531: aload 4
    //   533: invokevirtual 566	com/tencent/smtt/utils/TbsCopyVerify:generateReferenceValue	(Ljava/io/File;)V
    //   536: invokestatic 571	java/lang/System:currentTimeMillis	()J
    //   539: lstore 16
    //   541: aload 4
    //   543: aload 10
    //   545: invokestatic 575	com/tencent/smtt/utils/FileUtil:copyFiles	(Ljava/io/File;Ljava/io/File;)Z
    //   548: istore 20
    //   550: ldc -111
    //   552: new 383	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 577
    //   562: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: invokestatic 571	java/lang/System:currentTimeMillis	()J
    //   568: lload 16
    //   570: lsub
    //   571: invokevirtual 545	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   574: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   580: iload 20
    //   582: ifeq +817 -> 1399
    //   585: aload 5
    //   587: aload 4
    //   589: invokevirtual 580	com/tencent/smtt/utils/TbsCopyVerify:generateVerifyValue	(Ljava/io/File;)V
    //   592: aload 5
    //   594: invokevirtual 583	com/tencent/smtt/utils/TbsCopyVerify:verify	()Z
    //   597: ifne +49 -> 646
    //   600: ldc -111
    //   602: ldc_w 585
    //   605: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   608: aload 10
    //   610: iconst_1
    //   611: invokestatic 338	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   614: aload_2
    //   615: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   618: sipush 213
    //   621: ldc_w 587
    //   624: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   627: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   630: invokeinterface 500 1 0
    //   635: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   638: invokeinterface 500 1 0
    //   643: goto -461 -> 182
    //   646: iconst_1
    //   647: istore 12
    //   649: aconst_null
    //   650: astore 6
    //   652: new 364	java/io/File
    //   655: dup
    //   656: aload 10
    //   658: ldc 103
    //   660: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   663: astore 4
    //   665: new 589	java/util/Properties
    //   668: dup
    //   669: invokespecial 590	java/util/Properties:<init>	()V
    //   672: astore 5
    //   674: aload 4
    //   676: ifnull +161 -> 837
    //   679: aload 4
    //   681: invokevirtual 377	java/io/File:exists	()Z
    //   684: ifeq +153 -> 837
    //   687: aload 5
    //   689: ifnull +148 -> 837
    //   692: new 592	java/io/FileInputStream
    //   695: dup
    //   696: aload 4
    //   698: invokespecial 593	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   701: astore 4
    //   703: aload 4
    //   705: astore 7
    //   707: aload 5
    //   709: aload 4
    //   711: invokevirtual 597	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   714: iconst_1
    //   715: istore 12
    //   717: aload 4
    //   719: ifnull +8 -> 727
    //   722: aload 4
    //   724: invokevirtual 598	java/io/FileInputStream:close	()V
    //   727: aload 5
    //   729: astore 4
    //   731: iload 12
    //   733: ifeq +803 -> 1536
    //   736: aload 10
    //   738: invokevirtual 602	java/io/File:listFiles	()[Ljava/io/File;
    //   741: astore 5
    //   743: iconst_0
    //   744: istore 13
    //   746: iconst_1
    //   747: istore 20
    //   749: iload 20
    //   751: istore 21
    //   753: iload 13
    //   755: aload 5
    //   757: arraylength
    //   758: if_icmpge +295 -> 1053
    //   761: aload 5
    //   763: iload 13
    //   765: aaload
    //   766: astore 6
    //   768: iload 20
    //   770: istore 21
    //   772: ldc 103
    //   774: aload 6
    //   776: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   779: invokevirtual 611	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   782: ifne +42 -> 824
    //   785: iload 20
    //   787: istore 21
    //   789: aload 6
    //   791: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   794: ldc_w 613
    //   797: invokevirtual 617	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   800: ifne +24 -> 824
    //   803: ldc -108
    //   805: aload 6
    //   807: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   810: invokevirtual 611	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   813: istore 21
    //   815: iload 21
    //   817: ifeq +114 -> 931
    //   820: iload 20
    //   822: istore 21
    //   824: iload 13
    //   826: iconst_1
    //   827: iadd
    //   828: istore 13
    //   830: iload 21
    //   832: istore 20
    //   834: goto -85 -> 749
    //   837: iconst_0
    //   838: istore 12
    //   840: aconst_null
    //   841: astore 4
    //   843: goto -126 -> 717
    //   846: astore 6
    //   848: aconst_null
    //   849: astore 5
    //   851: aconst_null
    //   852: astore 4
    //   854: aload 4
    //   856: astore 7
    //   858: aload 6
    //   860: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   863: aload 4
    //   865: ifnull +8 -> 873
    //   868: aload 4
    //   870: invokevirtual 598	java/io/FileInputStream:close	()V
    //   873: aload 5
    //   875: astore 4
    //   877: goto -146 -> 731
    //   880: astore_1
    //   881: aload 6
    //   883: astore 4
    //   885: aload 4
    //   887: ifnull +8 -> 895
    //   890: aload 4
    //   892: invokevirtual 598	java/io/FileInputStream:close	()V
    //   895: aload_1
    //   896: athrow
    //   897: astore_1
    //   898: aload_2
    //   899: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   902: sipush 215
    //   905: aload_1
    //   906: invokevirtual 619	java/lang/Exception:toString	()Ljava/lang/String;
    //   909: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   912: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   915: invokeinterface 500 1 0
    //   920: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   923: invokeinterface 500 1 0
    //   928: goto -746 -> 182
    //   931: aload 6
    //   933: invokestatic 625	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   936: astore 7
    //   938: aload 4
    //   940: aload 6
    //   942: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   945: ldc_w 315
    //   948: invokevirtual 629	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   951: astore 11
    //   953: aload 11
    //   955: ldc_w 315
    //   958: invokevirtual 611	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   961: ifne +54 -> 1015
    //   964: aload 7
    //   966: aload 11
    //   968: invokevirtual 611	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   971: ifeq +44 -> 1015
    //   974: ldc -111
    //   976: new 383	java/lang/StringBuilder
    //   979: dup
    //   980: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   983: ldc_w 631
    //   986: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: aload 6
    //   991: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   994: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: ldc_w 633
    //   1000: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1009: iconst_1
    //   1010: istore 21
    //   1012: goto -188 -> 824
    //   1015: iconst_0
    //   1016: istore 21
    //   1018: ldc -111
    //   1020: new 383	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   1027: ldc_w 635
    //   1030: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: aload 6
    //   1035: invokevirtual 605	java/io/File:getName	()Ljava/lang/String;
    //   1038: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: ldc_w 633
    //   1044: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1053: ldc -111
    //   1055: new 383	java/lang/StringBuilder
    //   1058: dup
    //   1059: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   1062: ldc_w 637
    //   1065: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: iload 21
    //   1070: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1079: iload 12
    //   1081: ifeq +54 -> 1135
    //   1084: iload 21
    //   1086: ifne +49 -> 1135
    //   1089: ldc -111
    //   1091: ldc_w 642
    //   1094: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1097: aload 10
    //   1099: iconst_1
    //   1100: invokestatic 338	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1103: aload_2
    //   1104: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1107: sipush 213
    //   1110: ldc_w 644
    //   1113: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1116: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1119: invokeinterface 500 1 0
    //   1124: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1127: invokeinterface 500 1 0
    //   1132: goto -950 -> 182
    //   1135: ldc -111
    //   1137: ldc_w 646
    //   1140: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1143: aload_1
    //   1144: invokestatic 651	com/tencent/smtt/sdk/TbsApkDownloader:getHostBackupApkPath	(Landroid/content/Context;)Ljava/io/File;
    //   1147: astore 4
    //   1149: aload 4
    //   1151: ifnull +36 -> 1187
    //   1154: aload 4
    //   1156: invokevirtual 377	java/io/File:exists	()Z
    //   1159: ifeq +28 -> 1187
    //   1162: aload_2
    //   1163: invokestatic 656	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1166: ifeq +156 -> 1322
    //   1169: ldc_w 658
    //   1172: astore_1
    //   1173: new 364	java/io/File
    //   1176: dup
    //   1177: aload 4
    //   1179: aload_1
    //   1180: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1183: aload_2
    //   1184: invokestatic 662	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1187: aload_2
    //   1188: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1191: iload_3
    //   1192: iconst_1
    //   1193: invokevirtual 325	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1196: aload_2
    //   1197: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1200: sipush 220
    //   1203: ldc_w 664
    //   1206: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1209: ldc -111
    //   1211: new 383	java/lang/StringBuilder
    //   1214: dup
    //   1215: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   1218: ldc_w 666
    //   1221: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1224: iload_3
    //   1225: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1234: getstatic 448	android/os/Build$VERSION:SDK_INT	I
    //   1237: bipush 11
    //   1239: if_icmplt +90 -> 1329
    //   1242: aload_2
    //   1243: ldc_w 450
    //   1246: iconst_4
    //   1247: invokevirtual 454	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1250: astore_1
    //   1251: aload_1
    //   1252: invokeinterface 670 1 0
    //   1257: astore_1
    //   1258: aload_1
    //   1259: ldc_w 672
    //   1262: iconst_0
    //   1263: invokeinterface 678 3 0
    //   1268: pop
    //   1269: aload_1
    //   1270: ldc_w 680
    //   1273: iconst_0
    //   1274: invokeinterface 678 3 0
    //   1279: pop
    //   1280: aload_1
    //   1281: ldc_w 682
    //   1284: iload_3
    //   1285: invokeinterface 678 3 0
    //   1290: pop
    //   1291: aload_1
    //   1292: invokeinterface 685 1 0
    //   1297: pop
    //   1298: aload_2
    //   1299: invokestatic 688	com/tencent/smtt/utils/TbsUtils:createDirectoryTBS	(Landroid/content/Context;)Z
    //   1302: pop
    //   1303: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1306: invokeinterface 500 1 0
    //   1311: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1314: invokeinterface 500 1 0
    //   1319: goto -1137 -> 182
    //   1322: ldc_w 690
    //   1325: astore_1
    //   1326: goto -153 -> 1173
    //   1329: aload_2
    //   1330: ldc_w 450
    //   1333: iconst_0
    //   1334: invokevirtual 454	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1337: astore_1
    //   1338: goto -87 -> 1251
    //   1341: astore_1
    //   1342: ldc -111
    //   1344: new 383	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   1351: ldc_w 692
    //   1354: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: aload_1
    //   1358: invokestatic 698	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1361: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1367: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1370: goto -72 -> 1298
    //   1373: astore_1
    //   1374: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1377: invokeinterface 500 1 0
    //   1382: getstatic 220	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1385: invokeinterface 500 1 0
    //   1390: aload 9
    //   1392: aload 8
    //   1394: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1397: aload_1
    //   1398: athrow
    //   1399: ldc -111
    //   1401: ldc_w 700
    //   1404: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1407: aload_2
    //   1408: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1411: iload_3
    //   1412: iconst_2
    //   1413: invokevirtual 325	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1416: aload 10
    //   1418: iconst_0
    //   1419: invokestatic 338	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1422: aload_2
    //   1423: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1426: sipush 212
    //   1429: ldc_w 702
    //   1432: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1435: goto -132 -> 1303
    //   1438: aload 4
    //   1440: ifnonnull +16 -> 1456
    //   1443: aload_2
    //   1444: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1447: sipush 213
    //   1450: ldc_w 704
    //   1453: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1456: aload 10
    //   1458: ifnonnull -155 -> 1303
    //   1461: aload_2
    //   1462: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1465: sipush 214
    //   1468: ldc_w 706
    //   1471: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1474: goto -171 -> 1303
    //   1477: aload 9
    //   1479: aload 8
    //   1481: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   1484: return
    //   1485: astore 4
    //   1487: aload 4
    //   1489: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   1492: goto -597 -> 895
    //   1495: astore 4
    //   1497: aload 4
    //   1499: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   1502: goto -629 -> 873
    //   1505: astore 4
    //   1507: aload 4
    //   1509: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   1512: goto -785 -> 727
    //   1515: astore_1
    //   1516: aload 7
    //   1518: astore 4
    //   1520: goto -635 -> 885
    //   1523: astore 6
    //   1525: aconst_null
    //   1526: astore 4
    //   1528: goto -674 -> 854
    //   1531: astore 6
    //   1533: goto -679 -> 854
    //   1536: iconst_1
    //   1537: istore 21
    //   1539: goto -486 -> 1053
    //   1542: iload 13
    //   1544: ifle +12 -> 1556
    //   1547: iload_3
    //   1548: iload 13
    //   1550: if_icmple +6 -> 1556
    //   1553: goto -1282 -> 271
    //   1556: iload 12
    //   1558: istore 13
    //   1560: iload 12
    //   1562: iconst_3
    //   1563: if_icmpne -1267 -> 296
    //   1566: iload 12
    //   1568: istore 13
    //   1570: iload 14
    //   1572: ifle -1276 -> 296
    //   1575: iload_3
    //   1576: iload 14
    //   1578: if_icmpgt -1299 -> 279
    //   1581: iload 12
    //   1583: istore 13
    //   1585: iload_3
    //   1586: ldc_w 707
    //   1589: if_icmpne -1293 -> 296
    //   1592: goto -1313 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1595	0	this	TbsInstaller
    //   0	1595	1	paramContext1	Context
    //   0	1595	2	paramContext2	Context
    //   0	1595	3	paramInt	int
    //   33	1406	4	localObject1	Object
    //   1485	3	4	localIOException1	java.io.IOException
    //   1495	3	4	localIOException2	java.io.IOException
    //   1505	3	4	localIOException3	java.io.IOException
    //   1518	9	4	localObject2	Object
    //   527	347	5	localObject3	Object
    //   650	156	6	localObject4	Object
    //   846	188	6	localException1	Exception
    //   1523	1	6	localException2	Exception
    //   1531	1	6	localException3	Exception
    //   705	812	7	localObject5	Object
    //   103	1377	8	localFileOutputStream	FileOutputStream
    //   116	1362	9	localFileLock	FileLock
    //   495	962	10	localFile	File
    //   951	16	11	str	String
    //   158	1424	12	i	int
    //   149	1435	13	j	int
    //   195	1384	14	k	int
    //   255	11	15	m	int
    //   318	251	16	l1	long
    //   328	37	18	l2	long
    //   548	285	20	bool1	boolean
    //   751	787	21	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   652	674	846	java/lang/Exception
    //   652	674	880	finally
    //   679	687	880	finally
    //   692	703	880	finally
    //   142	160	897	java/lang/Exception
    //   190	223	897	java/lang/Exception
    //   248	257	897	java/lang/Exception
    //   271	276	897	java/lang/Exception
    //   282	296	897	java/lang/Exception
    //   296	376	897	java/lang/Exception
    //   424	433	897	java/lang/Exception
    //   440	453	897	java/lang/Exception
    //   472	483	897	java/lang/Exception
    //   483	497	897	java/lang/Exception
    //   507	580	897	java/lang/Exception
    //   585	627	897	java/lang/Exception
    //   722	727	897	java/lang/Exception
    //   736	743	897	java/lang/Exception
    //   753	761	897	java/lang/Exception
    //   772	785	897	java/lang/Exception
    //   789	815	897	java/lang/Exception
    //   868	873	897	java/lang/Exception
    //   890	895	897	java/lang/Exception
    //   895	897	897	java/lang/Exception
    //   931	1009	897	java/lang/Exception
    //   1018	1053	897	java/lang/Exception
    //   1053	1079	897	java/lang/Exception
    //   1089	1116	897	java/lang/Exception
    //   1135	1149	897	java/lang/Exception
    //   1154	1169	897	java/lang/Exception
    //   1173	1187	897	java/lang/Exception
    //   1187	1251	897	java/lang/Exception
    //   1251	1298	897	java/lang/Exception
    //   1298	1303	897	java/lang/Exception
    //   1329	1338	897	java/lang/Exception
    //   1342	1370	897	java/lang/Exception
    //   1399	1435	897	java/lang/Exception
    //   1443	1456	897	java/lang/Exception
    //   1461	1474	897	java/lang/Exception
    //   1487	1492	897	java/lang/Exception
    //   1497	1502	897	java/lang/Exception
    //   1507	1512	897	java/lang/Exception
    //   1251	1298	1341	java/lang/Throwable
    //   142	160	1373	finally
    //   190	223	1373	finally
    //   248	257	1373	finally
    //   271	276	1373	finally
    //   282	296	1373	finally
    //   296	376	1373	finally
    //   424	433	1373	finally
    //   440	453	1373	finally
    //   472	483	1373	finally
    //   483	497	1373	finally
    //   507	580	1373	finally
    //   585	627	1373	finally
    //   722	727	1373	finally
    //   736	743	1373	finally
    //   753	761	1373	finally
    //   772	785	1373	finally
    //   789	815	1373	finally
    //   868	873	1373	finally
    //   890	895	1373	finally
    //   895	897	1373	finally
    //   898	912	1373	finally
    //   931	1009	1373	finally
    //   1018	1053	1373	finally
    //   1053	1079	1373	finally
    //   1089	1116	1373	finally
    //   1135	1149	1373	finally
    //   1154	1169	1373	finally
    //   1173	1187	1373	finally
    //   1187	1251	1373	finally
    //   1251	1298	1373	finally
    //   1298	1303	1373	finally
    //   1329	1338	1373	finally
    //   1342	1370	1373	finally
    //   1399	1435	1373	finally
    //   1443	1456	1373	finally
    //   1461	1474	1373	finally
    //   1487	1492	1373	finally
    //   1497	1502	1373	finally
    //   1507	1512	1373	finally
    //   890	895	1485	java/io/IOException
    //   868	873	1495	java/io/IOException
    //   722	727	1505	java/io/IOException
    //   707	714	1515	finally
    //   858	863	1515	finally
    //   679	687	1523	java/lang/Exception
    //   692	703	1523	java/lang/Exception
    //   707	714	1531	java/lang/Exception
  }
  
  private Context createHostContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  private void deleteOldTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.delete(getTbsCoreShareDir(paramContext), false);
  }
  
  /* Error */
  private boolean doTbsCoreDexOpt(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: ldc -111
    //   5: new 383	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 721
    //   15: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_2
    //   19: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iload_2
    //   29: tableswitch	default:+27->56, 0:+54->83, 1:+191->220, 2:+200->229
    //   56: ldc -111
    //   58: new 383	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   65: ldc_w 723
    //   68: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_2
    //   72: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 332	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   88: astore_3
    //   89: aload_3
    //   90: new 8	com/tencent/smtt/sdk/TbsInstaller$2
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 726	com/tencent/smtt/sdk/TbsInstaller$2:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;)V
    //   98: invokevirtual 729	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   101: astore 4
    //   103: aload 4
    //   105: arraylength
    //   106: istore 7
    //   108: getstatic 448	android/os/Build$VERSION:SDK_INT	I
    //   111: bipush 16
    //   113: if_icmpge +32 -> 145
    //   116: aload_1
    //   117: invokevirtual 732	android/content/Context:getPackageName	()Ljava/lang/String;
    //   120: ifnull +25 -> 145
    //   123: aload_1
    //   124: invokevirtual 732	android/content/Context:getPackageName	()Ljava/lang/String;
    //   127: ldc 21
    //   129: invokevirtual 735	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   132: istore 8
    //   134: iload 8
    //   136: ifeq +9 -> 145
    //   139: ldc2_w 736
    //   142: invokestatic 743	java/lang/Thread:sleep	(J)V
    //   145: aload_1
    //   146: invokevirtual 747	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   149: astore 5
    //   151: iload 6
    //   153: istore_2
    //   154: iload_2
    //   155: iload 7
    //   157: if_icmpge +100 -> 257
    //   160: ldc -111
    //   162: new 383	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 749
    //   172: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 4
    //   177: iload_2
    //   178: aaload
    //   179: invokevirtual 752	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   182: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: new 754	dalvik/system/DexClassLoader
    //   194: dup
    //   195: aload 4
    //   197: iload_2
    //   198: aaload
    //   199: invokevirtual 752	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   202: aload_3
    //   203: invokevirtual 752	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   206: aconst_null
    //   207: aload 5
    //   209: invokespecial 757	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   212: pop
    //   213: iload_2
    //   214: iconst_1
    //   215: iadd
    //   216: istore_2
    //   217: goto -63 -> 154
    //   220: aload_0
    //   221: aload_1
    //   222: invokevirtual 341	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreCopyDir	(Landroid/content/Context;)Ljava/io/File;
    //   225: astore_3
    //   226: goto -137 -> 89
    //   229: aload_0
    //   230: aload_1
    //   231: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   234: astore_3
    //   235: goto -146 -> 89
    //   238: astore_3
    //   239: aload_3
    //   240: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   243: aload_1
    //   244: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   247: sipush 209
    //   250: aload_3
    //   251: invokevirtual 619	java/lang/Exception:toString	()Ljava/lang/String;
    //   254: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   257: ldc -111
    //   259: ldc_w 759
    //   262: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: iconst_1
    //   266: ireturn
    //   267: astore 5
    //   269: goto -124 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	TbsInstaller
    //   0	272	1	paramContext	Context
    //   0	272	2	paramInt	int
    //   88	147	3	localFile	File
    //   238	13	3	localException1	Exception
    //   101	95	4	arrayOfFile	File[]
    //   149	59	5	localClassLoader	ClassLoader
    //   267	1	5	localException2	Exception
    //   1	151	6	i	int
    //   106	52	7	j	int
    //   132	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   56	81	238	java/lang/Exception
    //   83	89	238	java/lang/Exception
    //   89	134	238	java/lang/Exception
    //   145	151	238	java/lang/Exception
    //   160	213	238	java/lang/Exception
    //   220	226	238	java/lang/Exception
    //   229	235	238	java/lang/Exception
    //   139	145	267	java/lang/Exception
  }
  
  private boolean enableTbsCoreFromCopy(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
    boolean bool4 = false;
    boolean bool2 = false;
    boolean bool1 = bool4;
    for (;;)
    {
      try
      {
        FileOutputStream localFileOutputStream = FileUtil.getLockFos(paramContext, true, "tbslock.txt");
        if (localFileOutputStream == null) {
          break;
        }
        bool1 = bool4;
        FileLock localFileLock = FileUtil.tryFileLock(paramContext, localFileOutputStream);
        if (localFileLock == null) {
          return false;
        }
        bool1 = bool4;
        boolean bool5 = mTbsRenameLock.tryLock();
        bool1 = bool4;
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + bool5);
        if (bool5) {}
        int i;
        int j;
        if (!paramBoolean) {
          break label319;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyStatus();
          j = getTbsCoreInstalledVerInNolock(paramContext);
          TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + i);
          TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + j);
          if (i != 1) {
            break label319;
          }
          if (j == 0)
          {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
            generateNewTbsCoreFromCopy(paramContext);
            paramBoolean = bool3;
          }
        }
        finally
        {
          bool1 = bool4;
          mTbsRenameLock.unlock();
          bool1 = bool4;
        }
        try
        {
          mTbsRenameLock.unlock();
          bool2 = paramBoolean;
          bool1 = bool2;
          FileUtil.freeFileLock(localFileLock, localFileOutputStream);
          return bool2;
        }
        catch (Throwable localThrowable2)
        {
          bool1 = paramBoolean;
          continue;
        }
        localThrowable1 = localThrowable1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable1.toString());
        QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(localThrowable1));
        return bool1;
      }
      finally {}
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
      generateNewTbsCoreFromCopy(paramContext);
      paramBoolean = bool3;
      continue;
      label319:
      paramBoolean = false;
    }
    return false;
  }
  
  /* Error */
  private boolean enableTbsCoreFromUnzip(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc -111
    //   2: new 383	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 782
    //   12: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_2
    //   16: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload_1
    //   26: iconst_1
    //   27: ldc_w 474
    //   30: invokestatic 478	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +204 -> 239
    //   38: aload_1
    //   39: aload_3
    //   40: invokestatic 482	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnonnull +5 -> 52
    //   50: iconst_0
    //   51: ireturn
    //   52: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   55: invokeinterface 487 1 0
    //   60: istore 7
    //   62: ldc -111
    //   64: new 383	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   71: ldc_w 784
    //   74: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: iload 7
    //   79: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   82: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload 7
    //   90: ifeq +78 -> 168
    //   93: aload_1
    //   94: invokestatic 302	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   97: invokevirtual 787	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallStatus	()I
    //   100: istore 5
    //   102: ldc -111
    //   104: new 383	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 789
    //   114: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload 5
    //   119: invokevirtual 467	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   122: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: aload_1
    //   130: invokevirtual 508	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   133: istore 6
    //   135: iload 5
    //   137: iconst_2
    //   138: if_icmpne +22 -> 160
    //   141: iload 6
    //   143: ifne +64 -> 207
    //   146: ldc -111
    //   148: ldc_w 791
    //   151: iconst_0
    //   152: invokestatic 520	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   155: aload_0
    //   156: aload_1
    //   157: invokespecial 794	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromUnzip	(Landroid/content/Context;)V
    //   160: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   163: invokeinterface 500 1 0
    //   168: aload 4
    //   170: aload_3
    //   171: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_3
    //   177: aload_1
    //   178: new 383	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   185: ldc_w 796
    //   188: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: aload_3
    //   192: invokevirtual 799	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 352	com/tencent/smtt/sdk/QbSdk:forceSysWebViewInner	(Landroid/content/Context;Ljava/lang/String;)V
    //   201: aload_3
    //   202: invokevirtual 618	java/lang/Exception:printStackTrace	()V
    //   205: iconst_0
    //   206: ireturn
    //   207: iload_2
    //   208: ifeq -48 -> 160
    //   211: ldc -111
    //   213: ldc_w 801
    //   216: iconst_0
    //   217: invokestatic 520	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   220: aload_0
    //   221: aload_1
    //   222: invokespecial 794	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromUnzip	(Landroid/content/Context;)V
    //   225: goto -65 -> 160
    //   228: astore_3
    //   229: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   232: invokeinterface 500 1 0
    //   237: aload_3
    //   238: athrow
    //   239: iconst_0
    //   240: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	TbsInstaller
    //   0	241	1	paramContext	Context
    //   0	241	2	paramBoolean	boolean
    //   33	138	3	localFileOutputStream	FileOutputStream
    //   176	26	3	localException	Exception
    //   228	10	3	localObject	Object
    //   43	126	4	localFileLock	FileLock
    //   100	39	5	i	int
    //   133	9	6	j	int
    //   60	29	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   25	34	176	java/lang/Exception
    //   38	45	176	java/lang/Exception
    //   52	88	176	java/lang/Exception
    //   160	168	176	java/lang/Exception
    //   168	174	176	java/lang/Exception
    //   229	239	176	java/lang/Exception
    //   93	135	228	finally
    //   146	160	228	finally
    //   211	225	228	finally
  }
  
  private void finishLocalTbsInstall(int paramInt, String paramString, Context paramContext)
  {
    new File(paramString).delete();
    TbsLog.i("TbsInstaller", "Local tbs apk(" + paramString + ") is deleted!", true);
    paramString = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((paramString != null) && (paramString.canRead()))
    {
      paramContext = new File(paramString, "tbs.conf");
      paramString = new Properties();
    }
    try
    {
      paramString.load(new FileInputStream(paramContext));
      paramContext = new FileOutputStream(paramContext);
      paramString.setProperty("tbs_local_installation", "true");
      paramString.store(paramContext, null);
      TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void generateNewTbsCoreFromCopy(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    try
    {
      deleteOldTbsCore(paramContext);
      renameTbsCoreCopyDir(paramContext);
      TbsShareManager.shareTbsCore(paramContext);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, 3);
      this.mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
    }
  }
  
  private void generateNewTbsCoreFromUnzip(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    try
    {
      deleteOldTbsCore(paramContext);
      renameTbsCoreShareDir(paramContext);
      if (!TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.shareTbsCore(paramContext);
      }
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 3);
      TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, getTbsCoreInstalledVer(paramContext), true);
      }
      this.mTbsCoreInstalledVer = 0;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localException.toString());
      TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
    }
  }
  
  /* Error */
  private String getInstalledTbsTimeStamp(Context paramContext)
  {
    // Byte code:
    //   0: new 364	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc -108
    //   11: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 377	java/io/File:exists	()Z
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +17 -> 42
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 866	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 867	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: aconst_null
    //   41: areturn
    //   42: new 589	java/util/Properties
    //   45: dup
    //   46: invokespecial 590	java/util/Properties:<init>	()V
    //   49: astore_2
    //   50: new 592	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 593	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: astore_1
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 597	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_1
    //   65: invokevirtual 598	java/io/FileInputStream:close	()V
    //   68: aload_2
    //   69: ldc -105
    //   71: invokevirtual 870	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore_2
    //   75: aload_2
    //   76: ifnonnull +16 -> 92
    //   79: aload_1
    //   80: ifnull -40 -> 40
    //   83: aload_1
    //   84: invokevirtual 598	java/io/FileInputStream:close	()V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_1
    //   90: aconst_null
    //   91: areturn
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 598	java/io/FileInputStream:close	()V
    //   100: aload_2
    //   101: areturn
    //   102: astore_2
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 598	java/io/FileInputStream:close	()V
    //   113: aload_2
    //   114: athrow
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -79 -> 40
    //   122: aload_1
    //   123: invokevirtual 598	java/io/FileInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: goto -16 -> 113
    //   132: astore_1
    //   133: goto -33 -> 100
    //   136: astore_2
    //   137: goto -32 -> 105
    //   140: astore_2
    //   141: goto -23 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	TbsInstaller
    //   0	144	1	paramContext	Context
    //   49	52	2	localObject1	Object
    //   102	12	2	localObject2	Object
    //   136	1	2	localObject3	Object
    //   140	1	2	localException	Exception
    //   23	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   32	40	89	java/io/IOException
    //   83	87	89	java/io/IOException
    //   122	126	89	java/io/IOException
    //   0	15	102	finally
    //   19	24	102	finally
    //   42	59	102	finally
    //   0	15	115	java/lang/Exception
    //   19	24	115	java/lang/Exception
    //   42	59	115	java/lang/Exception
    //   109	113	128	java/io/IOException
    //   96	100	132	java/io/IOException
    //   59	75	136	finally
    //   59	75	140	java/lang/Exception
  }
  
  static TbsInstaller getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TbsInstaller();
      }
      TbsInstaller localTbsInstaller = mInstance;
      return localTbsInstaller;
    }
    finally {}
  }
  
  private Context getTbsCoreHostContext(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i])) {}
      Context localContext;
      label142:
      int j;
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (isHostAppInstalled(paramContext, arrayOfString[i]))
          {
            localContext = createHostContext(paramContext, arrayOfString[i]);
            if (localContext != null)
            {
              if (vertificateApp(localContext)) {
                break label142;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i] + " illegal signature go on next");
            }
          }
        }
        j = getTbsCoreInstalledVerInNolock(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + j);
      } while ((j == 0) || (j != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i]);
      return localContext;
    }
    return null;
  }
  
  static File getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private String getTbsCoreTimeStampFromApk(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 128);
    if (paramContext != null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreTimeStampFromApk  timestamp=" + paramContext.applicationInfo.metaData.getString("TIMESTAMP"));
      return paramContext.applicationInfo.metaData.getString("TIMESTAMP");
    }
    return null;
  }
  
  @TargetApi(11)
  private void installTbsCoreInThread(Context paramContext, String paramString, int paramInt)
  {
    int j = -1;
    if (isTbsLocalInstalled(paramContext)) {
      TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
    }
    Object localObject;
    FileOutputStream localFileOutputStream;
    FileLock localFileLock;
    do
    {
      do
      {
        return;
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + paramString);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + paramInt);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if (Build.VERSION.SDK_INT >= 11) {}
        for (localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4); ((SharedPreferences)localObject).getInt("tbs_precheck_disable_version", -1) == paramInt; localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
        {
          TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + paramInt + " is disabled by preload_x5_check!");
          return;
        }
        if ((paramString != null) && (paramString.length() > 0) && (TbsUtils.getROMAvailableSize() < 6L * TbsUtils.getApkSize(paramString)))
        {
          long l1 = TbsUtils.getROMAvailableSize();
          long l2 = TbsUtils.getApkSize(paramString);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + l1 + ",minReqRom=" + 6L * l2);
          return;
        }
        localFileOutputStream = FileUtil.getLockFos(paramContext, true, "tbslock.txt");
      } while (localFileOutputStream == null);
      localFileLock = FileUtil.tryFileLock(paramContext, localFileOutputStream);
    } while (localFileLock == null);
    boolean bool = mTbsInstallLock.tryLock();
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + bool);
    if (bool) {
      mTbsRenameLock.lock();
    }
    for (;;)
    {
      int i;
      try
      {
        i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyVer();
        k = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallVer();
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + k);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + paramInt);
        if ((k <= 0) || (paramInt <= k)) {
          break label1413;
        }
        cleanStatusAndTmpDir(paramContext);
        i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
        k = getTbsCoreInstalledVerInNolock(paramContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + k);
        if ((i >= 0) && (i < 2))
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
          j = 1;
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i);
          if (i >= 1) {
            break label1401;
          }
          TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
          QbSdk.setTBSInstallingStatus(true);
          if (j == 0) {
            continue;
          }
          k = TbsCoreVerManager.getInstance(paramContext).getTbsCoreUnzipRetryNum();
          if (k > 10)
          {
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(201, "exceed unzip retry num!");
            clearNewTbsCore(paramContext);
            QbSdk.setTBSInstallingStatus(false);
          }
        }
        else
        {
          if ((i != 3) || (k <= 0) || ((paramInt <= k) && (paramInt != 88888888))) {
            break label1407;
          }
          cleanStatusAndTmpDir(paramContext);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
          k = 0;
          i = j;
          j = k;
          continue;
        }
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(k + 1);
        if (paramString != null) {
          break label1395;
        }
        localObject = TbsCoreVerManager.getInstance(paramContext).getTbsApkPath();
        if (localObject == null)
        {
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(202, "apk path is null!");
          QbSdk.setTBSInstallingStatus(false);
          return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + (String)localObject);
        k = getTbsCoreVerFromApk(paramContext, (String)localObject);
        if (k == 0)
        {
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(203, "apk version is 0!");
          QbSdk.setTBSInstallingStatus(false);
          return;
        }
        TbsCoreVerManager.getInstance(paramContext).setTbsApkPath((String)localObject);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(k, 0);
        if (!unzipTbsApk(paramContext, new File((String)localObject)))
        {
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(207, "unzipTbsApk failed");
          QbSdk.setTBSInstallingStatus(false);
          return;
        }
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(k, 1);
        if (i < 2)
        {
          if (j != 0)
          {
            i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreDexoptRetryNum();
            if (i > 10)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(208, "exceed dexopt retry num!");
              clearNewTbsCore(paramContext);
              QbSdk.setTBSInstallingStatus(false);
              return;
            }
            TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(i + 1);
          }
          bool = doTbsCoreDexOpt(paramContext, 0);
          if (!bool) {
            return;
          }
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(k, 2);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + paramInt);
          if (Build.VERSION.SDK_INT < 11) {
            continue;
          }
          localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        }
        try
        {
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_counter", 0);
          ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_recorder", 0);
          ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_version", paramInt);
          ((SharedPreferences.Editor)localObject).commit();
          if (paramInt == 88888888) {
            finishLocalTbsInstall(paramInt, paramString, paramContext);
          }
          paramString = TbsLogReport.getInstance(paramContext);
          if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus() == 1)
          {
            paramInt = 221;
            paramString.setInstallErrorCode(paramInt, "success");
            return;
            localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(localThrowable));
          continue;
        }
        paramInt = 200;
      }
      finally
      {
        mTbsRenameLock.unlock();
        mTbsInstallLock.unlock();
        FileUtil.freeFileLock(localFileLock, localFileOutputStream);
      }
      continue;
      FileUtil.freeFileLock(localFileLock, localFileOutputStream);
      return;
      label1395:
      String str = paramString;
      continue;
      label1401:
      int k = 0;
      continue;
      label1407:
      j = 0;
      continue;
      label1413:
      if ((i <= 0) || (paramInt <= i)) {}
    }
  }
  
  private boolean isHostAppInstalled(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private boolean isPrepareTbsCore(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
    if ((paramContext == null) || (!paramContext.exists())) {}
    do
    {
      return false;
      paramContext = new File(paramContext, "tbs.conf");
    } while ((paramContext == null) || (!paramContext.exists()));
    return true;
  }
  
  private void renameTbsCoreCopyDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile = getTmpTbsCoreCopyDir(paramContext);
    paramContext = getTbsCoreShareDir(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  private void renameTbsCoreShareDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile = getTmpTbsCoreUnzipDir(paramContext);
    paramContext = getTbsCoreShareDir(paramContext);
    if ((localFile == null) || (paramContext == null)) {
      return;
    }
    localFile.renameTo(paramContext);
  }
  
  /* Error */
  private boolean unzipTbsApk(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: ldc -111
    //   8: ldc_w 1059
    //   11: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_2
    //   15: invokestatic 1062	com/tencent/smtt/utils/FileUtil:isFileValid	(Ljava/io/File;)Z
    //   18: ifne +18 -> 36
    //   21: aload_1
    //   22: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   25: sipush 204
    //   28: ldc_w 1064
    //   31: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   34: iconst_0
    //   35: ireturn
    //   36: new 364	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: ldc -92
    //   43: iconst_0
    //   44: invokevirtual 370	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   47: ldc -65
    //   49: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull +14 -> 68
    //   57: aload_3
    //   58: invokevirtual 377	java/io/File:exists	()Z
    //   61: ifeq +7 -> 68
    //   64: aload_3
    //   65: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 332	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +50 -> 125
    //   78: aload_1
    //   79: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   82: sipush 205
    //   85: ldc_w 1068
    //   88: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   91: iconst_0
    //   92: ireturn
    //   93: astore_3
    //   94: ldc -111
    //   96: new 383	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 1070
    //   106: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokestatic 698	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   113: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 472	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: goto -54 -> 68
    //   125: aload_3
    //   126: invokestatic 1073	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   129: pop
    //   130: aload_2
    //   131: aload_3
    //   132: invokestatic 1076	com/tencent/smtt/utils/FileUtil:copyTbsFilesIfNeeded	(Ljava/io/File;Ljava/io/File;)Z
    //   135: istore 6
    //   137: iload 6
    //   139: ifne +36 -> 175
    //   142: aload_3
    //   143: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   146: ldc -111
    //   148: new 383	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 1078
    //   158: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_3
    //   162: invokevirtual 377	java/io/File:exists	()Z
    //   165: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: ldc -111
    //   177: ldc_w 1083
    //   180: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload 6
    //   185: ireturn
    //   186: astore_2
    //   187: aload_1
    //   188: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   191: sipush 206
    //   194: aload_2
    //   195: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   198: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   201: aload_3
    //   202: ifnull +228 -> 430
    //   205: aload_3
    //   206: invokevirtual 377	java/io/File:exists	()Z
    //   209: istore 6
    //   211: iload 6
    //   213: ifeq +217 -> 430
    //   216: iload 4
    //   218: ifeq +40 -> 258
    //   221: aload_3
    //   222: ifnull +36 -> 258
    //   225: aload_3
    //   226: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   229: ldc -111
    //   231: new 383	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 1086
    //   241: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_3
    //   245: invokevirtual 377	java/io/File:exists	()Z
    //   248: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   251: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   257: pop
    //   258: ldc -111
    //   260: ldc_w 1083
    //   263: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: iconst_0
    //   267: ireturn
    //   268: astore_2
    //   269: aload_1
    //   270: invokestatic 540	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   273: sipush 207
    //   276: aload_2
    //   277: invokevirtual 619	java/lang/Exception:toString	()Ljava/lang/String;
    //   280: invokevirtual 551	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   283: aload_3
    //   284: ifnull +140 -> 424
    //   287: aload_3
    //   288: invokevirtual 377	java/io/File:exists	()Z
    //   291: istore 6
    //   293: iload 6
    //   295: ifeq +129 -> 424
    //   298: iload 5
    //   300: istore 4
    //   302: iload 4
    //   304: ifeq +40 -> 344
    //   307: aload_3
    //   308: ifnull +36 -> 344
    //   311: aload_3
    //   312: invokestatic 1066	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   315: ldc -111
    //   317: new 383	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 1086
    //   327: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_3
    //   331: invokevirtual 377	java/io/File:exists	()Z
    //   334: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   337: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   343: pop
    //   344: goto -86 -> 258
    //   347: astore_1
    //   348: ldc -111
    //   350: ldc_w 1083
    //   353: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload_1
    //   357: athrow
    //   358: astore_1
    //   359: ldc -111
    //   361: new 383	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 1088
    //   371: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload_1
    //   375: invokestatic 698	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   378: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   387: pop
    //   388: goto -130 -> 258
    //   391: astore_1
    //   392: ldc -111
    //   394: new 383	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 1088
    //   404: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_1
    //   408: invokestatic 698	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   411: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 1081	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   420: pop
    //   421: goto -77 -> 344
    //   424: iconst_0
    //   425: istore 4
    //   427: goto -125 -> 302
    //   430: iconst_0
    //   431: istore 4
    //   433: goto -217 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	this	TbsInstaller
    //   0	436	1	paramContext	Context
    //   0	436	2	paramFile	File
    //   52	23	3	localFile	File
    //   93	238	3	localThrowable	Throwable
    //   4	428	4	i	int
    //   1	298	5	j	int
    //   135	159	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   36	53	93	java/lang/Throwable
    //   57	68	93	java/lang/Throwable
    //   125	137	186	java/io/IOException
    //   142	175	186	java/io/IOException
    //   125	137	268	java/lang/Exception
    //   142	175	268	java/lang/Exception
    //   125	137	347	finally
    //   142	175	347	finally
    //   187	201	347	finally
    //   205	211	347	finally
    //   269	283	347	finally
    //   287	293	347	finally
    //   225	258	358	java/lang/Throwable
    //   311	344	391	java/lang/Throwable
  }
  
  private boolean vertificateApp(Context paramContext)
  {
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      if (paramContext.getPackageName().equals("com.tencent.mtt"))
      {
        if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          break label189;
        }
        return false;
      }
      if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        if (localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
          break label189;
        }
      }
      else
      {
        if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
        {
          if (localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
            break label189;
          }
          return false;
        }
        if (paramContext.getPackageName().equals("com.tencent.x5sdk.demo"))
        {
          if (localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
            break label189;
          }
          return false;
        }
        if (paramContext.getPackageName().equals("com.qzone"))
        {
          if (localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
            break label189;
          }
          return false;
        }
        if (!paramContext.getPackageName().equals("com.tencent.qqpimsecure")) {
          break label189;
        }
        boolean bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (bool) {
          break label189;
        }
        return false;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    }
    return false;
    label189:
    return true;
  }
  
  void continueInstallTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    Object localObject = FileUtil.getLockFos(paramContext, true, "tbslock.txt");
    FileLock localFileLock;
    if (localObject != null)
    {
      localFileLock = FileUtil.tryFileLock(paramContext, (FileOutputStream)localObject);
      if (localFileLock != null) {}
    }
    else
    {
      return;
    }
    if (mTbsRenameLock.tryLock()) {}
    for (;;)
    {
      try
      {
        m = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
        k = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallVer();
        str = TbsCoreVerManager.getInstance(paramContext).getTbsApkPath();
        j = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyStatus();
        i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreCopyVer();
        mTbsRenameLock.unlock();
        FileUtil.freeFileLock(localFileLock, (FileOutputStream)localObject);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + m);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + k);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + j);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          installTbsCoreForThirdPartyApp(paramContext, TbsShareManager.getAvailableTbsCoreVersion(paramContext, false));
          return;
        }
      }
      finally
      {
        mTbsRenameLock.unlock();
      }
      localObject = new Bundle();
      ((Bundle)localObject).putInt("operation", 10001);
      installLocalTesCoreEx(paramContext, (Bundle)localObject);
      if ((m > -1) && (m < 2)) {
        installTbsCore(paramContext, str, k);
      }
      if (j != 0) {
        break;
      }
      installLocalTbsCore(paramContext, i);
      return;
      int j = -1;
      String str = null;
      int k = 0;
      int m = -1;
      int i = 0;
    }
  }
  
  /* Error */
  int getTbsCoreInstalledVer(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 474
    //   5: invokestatic 478	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 5
    //   18: invokestatic 482	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 487 1 0
    //   38: istore 7
    //   40: ldc -111
    //   42: new 383	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 1138
    //   52: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: iload 7
    //   57: invokevirtual 640	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: iload 7
    //   68: ifeq +260 -> 328
    //   71: new 364	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   80: ldc -108
    //   82: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +14 -> 101
    //   90: aload_1
    //   91: invokevirtual 377	java/io/File:exists	()Z
    //   94: istore 7
    //   96: iload 7
    //   98: ifne +32 -> 130
    //   101: iconst_0
    //   102: ifeq +11 -> 113
    //   105: new 866	java/lang/NullPointerException
    //   108: dup
    //   109: invokespecial 867	java/lang/NullPointerException:<init>	()V
    //   112: athrow
    //   113: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   116: invokeinterface 500 1 0
    //   121: aload 4
    //   123: aload 5
    //   125: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   128: iconst_0
    //   129: ireturn
    //   130: new 589	java/util/Properties
    //   133: dup
    //   134: invokespecial 590	java/util/Properties:<init>	()V
    //   137: astore_3
    //   138: new 592	java/io/FileInputStream
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 593	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   146: astore_2
    //   147: aload_2
    //   148: astore_1
    //   149: aload_3
    //   150: aload_2
    //   151: invokevirtual 597	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: invokevirtual 598	java/io/FileInputStream:close	()V
    //   160: aload_2
    //   161: astore_1
    //   162: aload_3
    //   163: ldc -102
    //   165: invokevirtual 870	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore_3
    //   169: aload_3
    //   170: ifnonnull +28 -> 198
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 598	java/io/FileInputStream:close	()V
    //   181: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   184: invokeinterface 500 1 0
    //   189: aload 4
    //   191: aload 5
    //   193: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   196: iconst_0
    //   197: ireturn
    //   198: aload_2
    //   199: astore_1
    //   200: aload_0
    //   201: aload_3
    //   202: invokestatic 1144	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   205: putfield 262	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	I
    //   208: aload_2
    //   209: astore_1
    //   210: aload_0
    //   211: getfield 262	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	I
    //   214: istore 6
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 598	java/io/FileInputStream:close	()V
    //   224: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   227: invokeinterface 500 1 0
    //   232: aload 4
    //   234: aload 5
    //   236: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   239: iload 6
    //   241: ireturn
    //   242: astore_3
    //   243: aconst_null
    //   244: astore_2
    //   245: aload_2
    //   246: astore_1
    //   247: ldc -111
    //   249: new 383	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   256: ldc_w 1146
    //   259: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload_3
    //   263: invokevirtual 619	java/lang/Exception:toString	()Ljava/lang/String;
    //   266: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload_2
    //   276: ifnull +7 -> 283
    //   279: aload_2
    //   280: invokevirtual 598	java/io/FileInputStream:close	()V
    //   283: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   286: invokeinterface 500 1 0
    //   291: aload 4
    //   293: aload 5
    //   295: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_1
    //   303: aload_1
    //   304: ifnull +7 -> 311
    //   307: aload_1
    //   308: invokevirtual 598	java/io/FileInputStream:close	()V
    //   311: getstatic 218	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   314: invokeinterface 500 1 0
    //   319: aload 4
    //   321: aload 5
    //   323: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   326: aload_2
    //   327: athrow
    //   328: aload 4
    //   330: aload 5
    //   332: invokestatic 504	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   335: iconst_0
    //   336: ireturn
    //   337: astore_1
    //   338: ldc -111
    //   340: new 383	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 1148
    //   350: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_1
    //   354: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   357: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -55 -> 311
    //   369: astore_1
    //   370: ldc -111
    //   372: new 383	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 1148
    //   382: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_1
    //   386: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   389: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: goto -115 -> 283
    //   401: astore_1
    //   402: ldc -111
    //   404: new 383	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 1148
    //   414: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_1
    //   418: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   421: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -317 -> 113
    //   433: astore_1
    //   434: ldc -111
    //   436: new 383	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 1148
    //   446: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_1
    //   450: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   453: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: goto -281 -> 181
    //   465: astore_1
    //   466: ldc -111
    //   468: new 383	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 1148
    //   478: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_1
    //   482: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   485: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: goto -270 -> 224
    //   497: astore_2
    //   498: goto -195 -> 303
    //   501: astore_3
    //   502: goto -257 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	TbsInstaller
    //   0	505	1	paramContext	Context
    //   146	134	2	localFileInputStream	FileInputStream
    //   300	27	2	localObject1	Object
    //   497	1	2	localObject2	Object
    //   137	65	3	localObject3	Object
    //   242	21	3	localException1	Exception
    //   501	1	3	localException2	Exception
    //   21	308	4	localFileLock	FileLock
    //   8	323	5	localFileOutputStream	FileOutputStream
    //   214	26	6	i	int
    //   38	59	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   71	86	242	java/lang/Exception
    //   90	96	242	java/lang/Exception
    //   130	147	242	java/lang/Exception
    //   71	86	300	finally
    //   90	96	300	finally
    //   130	147	300	finally
    //   307	311	337	java/io/IOException
    //   279	283	369	java/io/IOException
    //   105	113	401	java/io/IOException
    //   177	181	433	java/io/IOException
    //   220	224	465	java/io/IOException
    //   149	154	497	finally
    //   156	160	497	finally
    //   162	169	497	finally
    //   200	208	497	finally
    //   210	216	497	finally
    //   247	275	497	finally
    //   149	154	501	java/lang/Exception
    //   156	160	501	java/lang/Exception
    //   162	169	501	java/lang/Exception
    //   200	208	501	java/lang/Exception
    //   210	216	501	java/lang/Exception
  }
  
  /* Error */
  int getTbsCoreInstalledVerInNolock(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: new 364	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   15: ldc -108
    //   17: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +14 -> 36
    //   25: aload_1
    //   26: invokevirtual 377	java/io/File:exists	()Z
    //   29: istore 7
    //   31: iload 7
    //   33: ifne +18 -> 51
    //   36: iconst_0
    //   37: ifeq +11 -> 48
    //   40: new 866	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 867	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: iload 5
    //   50: ireturn
    //   51: new 589	java/util/Properties
    //   54: dup
    //   55: invokespecial 590	java/util/Properties:<init>	()V
    //   58: astore_3
    //   59: new 592	java/io/FileInputStream
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 593	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: aload_2
    //   72: invokevirtual 597	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: invokevirtual 598	java/io/FileInputStream:close	()V
    //   81: aload_2
    //   82: astore_1
    //   83: aload_3
    //   84: ldc -102
    //   86: invokevirtual 870	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore_3
    //   90: aload_3
    //   91: ifnonnull +47 -> 138
    //   94: aload_2
    //   95: ifnull -47 -> 48
    //   98: aload_2
    //   99: invokevirtual 598	java/io/FileInputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_1
    //   105: new 383	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 1150
    //   115: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_1
    //   119: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   122: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: astore_1
    //   129: ldc -111
    //   131: aload_1
    //   132: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: iload 4
    //   137: ireturn
    //   138: aload_2
    //   139: astore_1
    //   140: aload_3
    //   141: invokestatic 1144	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   144: istore 6
    //   146: iload 6
    //   148: istore 4
    //   150: iload 4
    //   152: istore 5
    //   154: aload_2
    //   155: ifnull -107 -> 48
    //   158: aload_2
    //   159: invokevirtual 598	java/io/FileInputStream:close	()V
    //   162: iload 4
    //   164: ireturn
    //   165: astore_1
    //   166: new 383	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 1150
    //   176: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_1
    //   180: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   183: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_1
    //   190: goto -61 -> 129
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: ldc -111
    //   200: new 383	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 1152
    //   210: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_3
    //   214: invokevirtual 619	java/lang/Exception:toString	()Ljava/lang/String;
    //   217: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_2
    //   227: ifnull -179 -> 48
    //   230: aload_2
    //   231: invokevirtual 598	java/io/FileInputStream:close	()V
    //   234: iconst_0
    //   235: ireturn
    //   236: astore_1
    //   237: new 383	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 1150
    //   247: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   254: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_1
    //   261: goto -132 -> 129
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_1
    //   267: aload_1
    //   268: ifnull +7 -> 275
    //   271: aload_1
    //   272: invokevirtual 598	java/io/FileInputStream:close	()V
    //   275: aload_2
    //   276: athrow
    //   277: astore_1
    //   278: ldc -111
    //   280: new 383	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1150
    //   290: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   297: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -31 -> 275
    //   309: astore_1
    //   310: new 383	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 1150
    //   320: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_1
    //   324: invokevirtual 1084	java/io/IOException:toString	()Ljava/lang/String;
    //   327: invokevirtual 390	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: astore_1
    //   334: goto -205 -> 129
    //   337: astore_2
    //   338: goto -71 -> 267
    //   341: astore_3
    //   342: goto -146 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	TbsInstaller
    //   0	345	1	paramContext	Context
    //   67	164	2	localFileInputStream	FileInputStream
    //   264	12	2	localObject1	Object
    //   337	1	2	localObject2	Object
    //   58	83	3	localObject3	Object
    //   193	21	3	localException1	Exception
    //   341	1	3	localException2	Exception
    //   1	162	4	i	int
    //   4	149	5	j	int
    //   144	3	6	k	int
    //   29	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   98	102	104	java/io/IOException
    //   158	162	165	java/io/IOException
    //   6	21	193	java/lang/Exception
    //   25	31	193	java/lang/Exception
    //   51	68	193	java/lang/Exception
    //   230	234	236	java/io/IOException
    //   6	21	264	finally
    //   25	31	264	finally
    //   51	68	264	finally
    //   271	275	277	java/io/IOException
    //   40	48	309	java/io/IOException
    //   70	75	337	finally
    //   77	81	337	finally
    //   83	90	337	finally
    //   140	146	337	finally
    //   198	226	337	finally
    //   70	75	341	java/lang/Exception
    //   77	81	341	java/lang/Exception
    //   83	90	341	java/lang/Exception
    //   140	146	341	java/lang/Exception
  }
  
  File getTbsCoreShareDir(Context paramContext)
  {
    return getTbsCoreShareDir(null, paramContext);
  }
  
  File getTbsCoreShareDir(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
  }
  
  int getTbsCoreVerFromApk(Context paramContext, String paramString)
  {
    int i = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      i = paramContext.versionCode;
    }
    return i;
  }
  
  File getTbsShareDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "share");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpStaticTbsCoreDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_static_tbs_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpTbsCoreCopyDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_copy_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpTbsCoreUnzipDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  public boolean hasStaticTbsInstalled(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  boolean installLocalTbsCore(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = getTbsCoreHostContext(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      mTbsInstallerHandler.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  void installLocalTbsCoreExInThread(Context paramContext, Bundle paramBundle)
  {
    if (isTbsLocalInstalled(paramContext)) {}
    Object localObject1;
    FileOutputStream localFileOutputStream;
    FileLock localFileLock;
    do
    {
      do
      {
        do
        {
          return;
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        } while ((paramBundle == null) || (paramContext == null));
        localObject1 = paramBundle.getString("old_apk_location");
        if ((localObject1 != null) && (((String)localObject1).length() > 0) && (TbsUtils.getROMAvailableSize() < 2L * TbsUtils.getApkSize((String)localObject1)))
        {
          long l1 = TbsUtils.getROMAvailableSize();
          long l2 = TbsUtils.getApkSize((String)localObject1);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + l1 + ",minReqRom=" + 2L * l2);
          return;
        }
        localFileOutputStream = FileUtil.getLockFos(paramContext, true, "tbslock.txt");
      } while (localFileOutputStream == null);
      localFileLock = FileUtil.tryFileLock(paramContext, localFileOutputStream);
    } while (localFileLock == null);
    boolean bool = mTbsInstallLock.tryLock();
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + bool);
    Object localObject4;
    Object localObject3;
    int j;
    if (bool)
    {
      localObject4 = null;
      localObject3 = null;
      j = 2;
      localObject1 = localObject4;
    }
    for (;;)
    {
      int k;
      try
      {
        if (getTbsCoreInstalledVerInNolock(paramContext) > 0)
        {
          localObject1 = localObject4;
          i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus();
          if (i != 1) {}
        }
        else
        {
          mTbsInstallLock.unlock();
          FileUtil.freeFileLock(localFileLock, localFileOutputStream);
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
          return;
        }
        localObject1 = localObject4;
        i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
        if (i == 1) {
          break label818;
        }
        if (i != 2) {
          continue;
        }
      }
      catch (Exception paramBundle)
      {
        File localFile;
        paramBundle = paramBundle;
        localObject2 = localObject1;
        i = j;
        paramBundle.printStackTrace();
        i = 1;
        localObject2 = localObject1;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(218, paramBundle.toString());
        mTbsInstallLock.unlock();
        FileUtil.freeFileLock(localFileLock, localFileOutputStream);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
        TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
        TbsDownloadConfig.getInstance(paramContext).commit();
        paramContext = TbsLogReport.getInstance(paramContext);
        paramContext.setInstallErrorCode(217, "incrUpdate fail!");
        return;
      }
      finally
      {
        localObject1 = null;
        i = 2;
      }
      Object localObject2 = localObject3;
      int i = j;
      if (k == 0)
      {
        localObject1 = localObject4;
        localFile = getTbsCorePrivateDir(paramContext);
        localObject2 = localObject3;
        i = j;
        if (localFile != null)
        {
          localObject1 = localObject4;
          localFile = new File(localFile, "x5.tbs");
          localObject2 = localObject3;
          i = j;
          if (localFile != null)
          {
            localObject2 = localObject3;
            i = j;
            localObject1 = localObject4;
            if (localFile.exists())
            {
              localObject1 = localObject4;
              paramBundle = QbSdk.incrUpdate(paramContext, paramBundle);
              if (paramBundle != null) {
                continue;
              }
              i = 1;
              localObject2 = paramBundle;
            }
          }
        }
      }
      mTbsInstallLock.unlock();
      FileUtil.freeFileLock(localFileLock, localFileOutputStream);
      if (i == 0)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
        paramBundle = ((Bundle)localObject2).getString("apk_path");
        TbsApkDownloader.backupTbsApk(new File(paramBundle), paramContext);
        installTbsCore(paramContext, paramBundle, ((Bundle)localObject2).getInt("tbs_core_ver"));
        return;
        k = 0;
        continue;
        localObject1 = paramBundle;
        localObject2 = paramBundle;
        i = j;
        mTbsInstallLock.unlock();
        FileUtil.freeFileLock(localFileLock, localFileOutputStream);
        if (i == 0)
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(1);
          localObject2 = ((Bundle)localObject1).getString("apk_path");
          TbsApkDownloader.backupTbsApk(new File((String)localObject2), paramContext);
          installTbsCore(paramContext, (String)localObject2, ((Bundle)localObject1).getInt("tbs_core_ver"));
        }
        for (;;)
        {
          throw paramBundle;
          FileUtil.freeFileLock(localFileLock, localFileOutputStream);
          return;
          if (i == 2)
          {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
          }
          else
          {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
            TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
            TbsDownloadConfig.getInstance(paramContext).commit();
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(217, "incrUpdate fail!");
          }
        }
      }
      else if (i != 2)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
        TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
        TbsDownloadConfig.getInstance(paramContext).commit();
        paramContext = TbsLogReport.getInstance(paramContext);
        continue;
        label818:
        k = 1;
      }
    }
  }
  
  void installLocalTesCoreEx(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCore(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCoreForThirdPartyApp(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int i;
    do
    {
      do
      {
        return;
        i = getTbsCoreInstalledVerInNolock(paramContext);
      } while (i == paramInt);
      Context localContext = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
      if (localContext != null)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        quickDexOptForThirdPartyApp(paramContext, localContext);
        return;
      }
    } while (i > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
  }
  
  void installTbsCoreIfNeeded(Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    if (QbSdk.mIsSysWebViewForcedByOuter) {}
    label92:
    label96:
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
      int i;
      if (!isPrepareTbsCore(paramContext, "core_copy_tmp"))
      {
        i = 0;
        if (isPrepareTbsCore(paramContext, "core_unzip_tmp")) {
          break label92;
        }
      }
      for (;;)
      {
        if (((i == 0) || (!enableTbsCoreFromCopy(paramContext, paramBoolean))) && ((j == 0) || (!enableTbsCoreFromUnzip(paramContext, paramBoolean)))) {
          break label96;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, SUCCESS!!", true);
        return;
        i = 1;
        break;
        j = 1;
      }
    }
  }
  
  boolean isTbsCoreLegal(Context paramContext, int paramInt)
  {
    for (;;)
    {
      int i;
      try
      {
        boolean bool = TbsShareManager.isThirdPartyApp(paramContext);
        File localFile;
        if (bool)
        {
          if (TbsShareManager.isShareTbsCoreAvailable(paramContext))
          {
            localFile = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
            if (localFile.getAbsolutePath().contains("com.tencent.x5sdk.demo")) {
              return true;
            }
          }
          else
          {
            TbsLog.e("loaderror", "321");
            return false;
          }
        }
        else
        {
          localFile = getTbsCoreShareDir(paramContext);
          if (localFile != null)
          {
            Long[][] arrayOfLong1 = WEBCORE_LIB_LENGTH_MAP;
            int j = arrayOfLong1.length;
            i = 0;
            if (i >= j) {
              break label246;
            }
            Long[] arrayOfLong = arrayOfLong1[i];
            if (paramInt != arrayOfLong[0].intValue()) {
              break label248;
            }
            localFile = new File(localFile, "libmttwebcore.so");
            if ((localFile != null) && (localFile.exists()) && (localFile.length() == arrayOfLong[1].longValue())) {
              break label246;
            }
            if (!bool) {
              FileUtil.delete(paramContext.getDir("tbs", 0));
            }
            this.mTbsCoreInstalledVer = 0;
            TbsLog.e("loaderror", "322");
            return false;
          }
          TbsLog.e("loaderror", "323");
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("loaderror", "ISTBSCORELEGAL exception getMessage is " + paramContext.getMessage());
        TbsLog.e("loaderror", "ISTBSCORELEGAL exception getCause is " + paramContext.getCause());
        return false;
      }
      continue;
      label246:
      return true;
      label248:
      i += 1;
    }
  }
  
  /* Error */
  boolean isTbsLocalInstalled(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: new 364	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 531	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   12: ldc -108
    //   14: invokespecial 373	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore_1
    //   18: iload 5
    //   20: istore 4
    //   22: aload_1
    //   23: ifnull +14 -> 37
    //   26: aload_1
    //   27: invokevirtual 377	java/io/File:exists	()Z
    //   30: ifne +10 -> 40
    //   33: iload 5
    //   35: istore 4
    //   37: iload 4
    //   39: ireturn
    //   40: new 589	java/util/Properties
    //   43: dup
    //   44: invokespecial 590	java/util/Properties:<init>	()V
    //   47: astore_3
    //   48: new 592	java/io/FileInputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 593	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 597	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   64: aload_2
    //   65: astore_1
    //   66: aload_3
    //   67: ldc -89
    //   69: ldc_w 1327
    //   72: invokevirtual 629	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 1330	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   78: invokevirtual 1333	java/lang/Boolean:booleanValue	()Z
    //   81: istore 4
    //   83: iload 4
    //   85: istore 5
    //   87: iload 5
    //   89: istore 4
    //   91: aload_2
    //   92: ifnull -55 -> 37
    //   95: aload_2
    //   96: invokevirtual 598	java/io/FileInputStream:close	()V
    //   99: iload 5
    //   101: ireturn
    //   102: astore_1
    //   103: aload_1
    //   104: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   107: iload 5
    //   109: ireturn
    //   110: astore_3
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore_1
    //   115: aload_3
    //   116: invokevirtual 827	java/lang/Throwable:printStackTrace	()V
    //   119: iload 5
    //   121: istore 4
    //   123: aload_2
    //   124: ifnull -87 -> 37
    //   127: aload_2
    //   128: invokevirtual 598	java/io/FileInputStream:close	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 598	java/io/FileInputStream:close	()V
    //   151: aload_2
    //   152: athrow
    //   153: astore_1
    //   154: aload_1
    //   155: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   158: goto -7 -> 151
    //   161: astore_2
    //   162: goto -19 -> 143
    //   165: astore_3
    //   166: goto -53 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	TbsInstaller
    //   0	169	1	paramContext	Context
    //   56	72	2	localFileInputStream	FileInputStream
    //   140	12	2	localObject1	Object
    //   161	1	2	localObject2	Object
    //   47	20	3	localProperties	Properties
    //   110	6	3	localThrowable1	Throwable
    //   165	1	3	localThrowable2	Throwable
    //   20	102	4	bool1	boolean
    //   1	119	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   95	99	102	java/io/IOException
    //   48	57	110	java/lang/Throwable
    //   127	131	133	java/io/IOException
    //   48	57	140	finally
    //   147	151	153	java/io/IOException
    //   59	64	161	finally
    //   66	83	161	finally
    //   115	119	161	finally
    //   59	64	165	java/lang/Throwable
    //   66	83	165	java/lang/Throwable
  }
  
  /* Error */
  public boolean quickDexOptForThirdPartyApp(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc -111
    //   4: ldc_w 1335
    //   7: invokestatic 297	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 258	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 258	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   27: new 10	com/tencent/smtt/sdk/TbsInstaller$3
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1338	com/tencent/smtt/sdk/TbsInstaller$3:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1341	com/tencent/smtt/sdk/TbsInstaller$3:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsInstaller
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  boolean tbsFileConfExists(Context paramContext)
  {
    paramContext = new File(getTbsCoreShareDir(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\TbsInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */