package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class IndividualRedPacketResDownloader$Char300Info
  extends IndividualRedPacketResDownloader.RedPacketResInfo
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public int c;
  
  public IndividualRedPacketResDownloader$Char300Info()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = 100;
    this.jdField_c_of_type_Int = 20;
  }
  
  /* Error */
  public String a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 31	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ifnonnull +205 -> 211
    //   9: aload_1
    //   10: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   13: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:o	Ljava/lang/String;
    //   16: ldc 44
    //   18: invokeinterface 50 3 0
    //   23: aload_0
    //   24: getfield 52	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   27: invokevirtual 58	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   30: ifeq +98 -> 128
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 60	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_Boolean	Z
    //   38: new 62	java/io/File
    //   41: dup
    //   42: aload_0
    //   43: getfield 52	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   46: ldc 44
    //   48: iconst_1
    //   49: iconst_0
    //   50: iconst_0
    //   51: invokestatic 65	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   54: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 72	java/io/File:exists	()Z
    //   62: ifeq +209 -> 271
    //   65: aload_1
    //   66: invokevirtual 75	java/io/File:isFile	()Z
    //   69: ifeq +202 -> 271
    //   72: aload_1
    //   73: invokestatic 80	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +176 -> 254
    //   81: new 82	org/json/JSONObject
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 83	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   89: ldc 85
    //   91: invokevirtual 89	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   94: astore_1
    //   95: new 91	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: iload_3
    //   104: aload_1
    //   105: invokevirtual 98	org/json/JSONArray:length	()I
    //   108: if_icmpge +95 -> 203
    //   111: aload_2
    //   112: aload_1
    //   113: iload_3
    //   114: invokevirtual 101	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   117: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: iload_3
    //   122: iconst_1
    //   123: iadd
    //   124: istore_3
    //   125: goto -22 -> 103
    //   128: aload_1
    //   129: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   132: invokeinterface 109 1 0
    //   137: getstatic 42	com/tencent/mobileqq/app/IndividualRedPacketManager:o	Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 52	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   144: invokeinterface 115 3 0
    //   149: invokeinterface 118 1 0
    //   154: pop
    //   155: aload_0
    //   156: iconst_1
    //   157: putfield 60	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_Boolean	Z
    //   160: goto -122 -> 38
    //   163: astore_1
    //   164: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +31 -> 198
    //   170: ldc 125
    //   172: iconst_2
    //   173: new 91	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   180: ldc 127
    //   182: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 131	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   189: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -123 -> 77
    //   203: aload_0
    //   204: aload_2
    //   205: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: putfield 31	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   211: aload_0
    //   212: getfield 31	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: areturn
    //   216: astore_1
    //   217: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq -9 -> 211
    //   223: ldc 125
    //   225: iconst_2
    //   226: new 91	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   233: ldc -116
    //   235: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_1
    //   239: invokevirtual 141	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: goto -40 -> 211
    //   254: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq -46 -> 211
    //   260: ldc 125
    //   262: iconst_2
    //   263: ldc -113
    //   265: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: goto -57 -> 211
    //   271: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq -63 -> 211
    //   277: ldc 125
    //   279: iconst_2
    //   280: ldc -108
    //   282: invokestatic 146	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: goto -74 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	Char300Info
    //   0	288	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   102	103	2	localStringBuilder	StringBuilder
    //   1	124	3	i	int
    // Exception table:
    //   from	to	target	type
    //   72	77	163	java/lang/OutOfMemoryError
    //   81	103	216	java/lang/Exception
    //   103	121	216	java/lang/Exception
    //   203	211	216	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vas\IndividualRedPacketResDownloader$Char300Info.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */