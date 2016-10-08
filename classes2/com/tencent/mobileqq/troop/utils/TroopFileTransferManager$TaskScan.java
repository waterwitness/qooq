package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class TroopFileTransferManager$TaskScan
  extends TroopFileTransferManager.Task
{
  public TroopFileTransferManager$TaskScan(TroopFileTransferManager paramTroopFileTransferManager, TroopFileTransferManager.Item paramItem)
  {
    super(paramTroopFileTransferManager, paramItem, 0);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    paramTroopFileTransferManager.a(paramItem, 0);
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   4: aload_0
    //   5: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   8: invokevirtual 44	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   11: ifeq +4 -> 15
    //   14: return
    //   15: aload_0
    //   16: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   19: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   22: ifnonnull +35 -> 57
    //   25: aload_0
    //   26: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   29: lconst_0
    //   30: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   33: aload_0
    //   34: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   37: ldc 56
    //   39: invokestatic 62	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   42: putfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   45: aload_0
    //   46: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   49: ldc 64
    //   51: invokestatic 62	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   54: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   57: new 69	java/io/File
    //   60: dup
    //   61: aload_0
    //   62: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   65: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   68: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_1
    //   73: invokevirtual 80	java/io/File:exists	()Z
    //   76: ifeq +30 -> 106
    //   79: aload_1
    //   80: invokevirtual 83	java/io/File:isFile	()Z
    //   83: ifeq +23 -> 106
    //   86: aload_1
    //   87: invokevirtual 87	java/io/File:length	()J
    //   90: lconst_0
    //   91: lcmp
    //   92: ifle +14 -> 106
    //   95: aload_0
    //   96: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   99: aload_1
    //   100: invokevirtual 87	java/io/File:length	()J
    //   103: putfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   106: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   109: ifeq +58 -> 167
    //   112: ldc 97
    //   114: iconst_2
    //   115: new 99	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   122: ldc 103
    //   124: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   131: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   134: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 109
    //   139: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_1
    //   143: invokevirtual 80	java/io/File:exists	()Z
    //   146: invokevirtual 112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: ldc 114
    //   151: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_1
    //   155: invokevirtual 87	java/io/File:length	()J
    //   158: invokevirtual 117	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   161: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 125	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: aload_0
    //   168: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   171: aload_0
    //   172: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   175: invokevirtual 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   178: aload_0
    //   179: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   182: getfield 90	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   185: ldc2_w 129
    //   188: lcmp
    //   189: ifle +39 -> 228
    //   192: aload_0
    //   193: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   196: aload_0
    //   197: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   200: iconst_3
    //   201: sipush 205
    //   204: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   207: return
    //   208: astore_1
    //   209: aload_1
    //   210: invokevirtual 136	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   213: aload_0
    //   214: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   217: aload_0
    //   218: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   221: iconst_3
    //   222: bipush 102
    //   224: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   227: return
    //   228: new 138	java/io/FileInputStream
    //   231: dup
    //   232: aload_1
    //   233: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   236: astore_1
    //   237: aload_1
    //   238: aload_0
    //   239: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   242: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   245: invokevirtual 145	java/io/FileInputStream:skip	(J)J
    //   248: pop2
    //   249: ldc -110
    //   251: newarray <illegal type>
    //   253: astore_2
    //   254: aload_1
    //   255: aload_2
    //   256: invokevirtual 150	java/io/FileInputStream:read	([B)I
    //   259: istore 4
    //   261: iload 4
    //   263: ifge +171 -> 434
    //   266: aload_1
    //   267: invokevirtual 153	java/io/FileInputStream:close	()V
    //   270: aload_0
    //   271: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   274: aload_0
    //   275: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   278: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   281: invokevirtual 157	java/security/MessageDigest:digest	()[B
    //   284: putfield 161	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Md5	[B
    //   287: aload_0
    //   288: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   291: aload_0
    //   292: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   295: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   298: invokevirtual 157	java/security/MessageDigest:digest	()[B
    //   301: putfield 164	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Sha	[B
    //   304: aload_0
    //   305: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   308: aconst_null
    //   309: putfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   312: aload_0
    //   313: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   316: aconst_null
    //   317: putfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   320: aload_0
    //   321: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   324: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   327: invokestatic 169	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)I
    //   330: ifne +50 -> 380
    //   333: new 171	android/graphics/BitmapFactory$Options
    //   336: dup
    //   337: invokespecial 172	android/graphics/BitmapFactory$Options:<init>	()V
    //   340: astore_1
    //   341: aload_1
    //   342: iconst_1
    //   343: putfield 175	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   346: aload_0
    //   347: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   350: getfield 73	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:LocalFile	Ljava/lang/String;
    //   353: aload_1
    //   354: invokestatic 181	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   357: pop
    //   358: aload_0
    //   359: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   362: aload_1
    //   363: getfield 185	android/graphics/BitmapFactory$Options:outWidth	I
    //   366: putfield 188	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:width	I
    //   369: aload_0
    //   370: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   373: aload_1
    //   374: getfield 191	android/graphics/BitmapFactory$Options:outHeight	I
    //   377: putfield 194	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:height	I
    //   380: aload_0
    //   381: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   384: aload_0
    //   385: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   388: invokevirtual 44	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   391: ifne -377 -> 14
    //   394: aload_0
    //   395: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   398: aload_0
    //   399: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   402: invokevirtual 128	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   405: aload_0
    //   406: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   409: aload_0
    //   410: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   413: invokevirtual 196	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   416: return
    //   417: astore_1
    //   418: aload_0
    //   419: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   422: aload_0
    //   423: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   426: iconst_3
    //   427: sipush 201
    //   430: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   433: return
    //   434: aload_0
    //   435: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   438: getfield 50	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestMd5	Ljava/security/MessageDigest;
    //   441: aload_2
    //   442: iconst_0
    //   443: iload 4
    //   445: invokevirtual 200	java/security/MessageDigest:update	([BII)V
    //   448: aload_0
    //   449: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   452: getfield 67	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:DigestSha	Ljava/security/MessageDigest;
    //   455: aload_2
    //   456: iconst_0
    //   457: iload 4
    //   459: invokevirtual 200	java/security/MessageDigest:update	([BII)V
    //   462: aload_0
    //   463: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   466: astore_3
    //   467: aload_3
    //   468: aload_3
    //   469: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   472: iload 4
    //   474: i2l
    //   475: ladd
    //   476: putfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ScanPos	J
    //   479: aload_0
    //   480: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   483: aload_0
    //   484: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   487: invokevirtual 44	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Z
    //   490: istore 5
    //   492: iload 5
    //   494: ifeq -240 -> 254
    //   497: aload_1
    //   498: invokevirtual 153	java/io/FileInputStream:close	()V
    //   501: return
    //   502: astore_1
    //   503: aload_1
    //   504: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   507: return
    //   508: astore_1
    //   509: aload_1
    //   510: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   513: goto -243 -> 270
    //   516: astore_2
    //   517: aload_2
    //   518: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   521: aload_0
    //   522: getfield 10	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:b	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager;
    //   525: aload_0
    //   526: getfield 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskScan:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager$Item	Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;
    //   529: iconst_3
    //   530: sipush 203
    //   533: invokevirtual 133	com/tencent/mobileqq/troop/utils/TroopFileTransferManager:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   536: aload_1
    //   537: invokevirtual 153	java/io/FileInputStream:close	()V
    //   540: return
    //   541: astore_1
    //   542: aload_1
    //   543: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   546: return
    //   547: astore_2
    //   548: aload_1
    //   549: invokevirtual 153	java/io/FileInputStream:close	()V
    //   552: aload_2
    //   553: athrow
    //   554: astore_1
    //   555: aload_1
    //   556: invokevirtual 201	java/io/IOException:printStackTrace	()V
    //   559: goto -7 -> 552
    //   562: astore_1
    //   563: goto -183 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	TaskScan
    //   71	84	1	localFile	java.io.File
    //   208	25	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   236	138	1	localObject1	Object
    //   417	81	1	localFileNotFoundException	java.io.FileNotFoundException
    //   502	2	1	localIOException1	java.io.IOException
    //   508	29	1	localIOException2	java.io.IOException
    //   541	8	1	localIOException3	java.io.IOException
    //   554	2	1	localIOException4	java.io.IOException
    //   562	1	1	localException	Exception
    //   253	203	2	arrayOfByte	byte[]
    //   516	2	2	localIOException5	java.io.IOException
    //   547	6	2	localObject2	Object
    //   466	3	3	localItem	TroopFileTransferManager.Item
    //   259	214	4	i	int
    //   490	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   33	57	208	java/security/NoSuchAlgorithmException
    //   228	237	417	java/io/FileNotFoundException
    //   497	501	502	java/io/IOException
    //   266	270	508	java/io/IOException
    //   237	254	516	java/io/IOException
    //   254	261	516	java/io/IOException
    //   434	492	516	java/io/IOException
    //   536	540	541	java/io/IOException
    //   237	254	547	finally
    //   254	261	547	finally
    //   434	492	547	finally
    //   517	536	547	finally
    //   548	552	554	java/io/IOException
    //   333	380	562	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopFileTransferManager$TaskScan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */