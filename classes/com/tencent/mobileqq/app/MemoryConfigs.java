package com.tencent.mobileqq.app;

public class MemoryConfigs
{
  private static MemoryConfigs a;
  private static final int jdField_b_of_type_Int = 7;
  private static final String jdField_b_of_type_JavaLangString = "Q.Memory.MemoryConfigs";
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public float b;
  public boolean b;
  public boolean c;
  
  /* Error */
  private MemoryConfigs()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 22	java/lang/Object:<init>	()V
    //   4: getstatic 27	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   7: istore_3
    //   8: aload_0
    //   9: ldc 29
    //   11: putfield 31	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   14: aload_0
    //   15: bipush 15
    //   17: putfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   20: aload_0
    //   21: ldc2_w 34
    //   24: putfield 37	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Long	J
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 39	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   32: aload_0
    //   33: ldc 40
    //   35: putfield 42	com/tencent/mobileqq/app/MemoryConfigs:jdField_b_of_type_Float	F
    //   38: invokestatic 47	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   41: astore_1
    //   42: aload_1
    //   43: getstatic 53	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:new_memory_strategy	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   46: invokevirtual 57	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   49: invokevirtual 60	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_2
    //   53: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +28 -> 84
    //   59: ldc 12
    //   61: iconst_2
    //   62: new 68	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   69: ldc 71
    //   71: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_2
    //   75: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_2
    //   85: invokestatic 88	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +12 -> 100
    //   91: aload_2
    //   92: ldc 90
    //   94: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +4 -> 101
    //   100: return
    //   101: aload_2
    //   102: ldc 98
    //   104: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: arraylength
    //   110: iconst_1
    //   111: if_icmple +193 -> 304
    //   114: aload_2
    //   115: aload_1
    //   116: getfield 103	com/tencent/mobileqq/app/DeviceProfileManager:jdField_a_of_type_Int	I
    //   119: aload_2
    //   120: arraylength
    //   121: irem
    //   122: aaload
    //   123: astore_1
    //   124: aload_1
    //   125: ldc 105
    //   127: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   130: astore_1
    //   131: aload_1
    //   132: arraylength
    //   133: bipush 7
    //   135: if_icmplt -35 -> 100
    //   138: aload_1
    //   139: iconst_1
    //   140: aaload
    //   141: ldc 107
    //   143: invokevirtual 102	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   146: astore_2
    //   147: aload_2
    //   148: iconst_0
    //   149: aaload
    //   150: ldc 109
    //   152: invokevirtual 96	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +46 -> 201
    //   158: aload_0
    //   159: iconst_1
    //   160: putfield 111	com/tencent/mobileqq/app/MemoryConfigs:jdField_b_of_type_Boolean	Z
    //   163: aload_0
    //   164: aload_2
    //   165: iconst_1
    //   166: aaload
    //   167: invokestatic 117	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: putfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   173: aload_0
    //   174: getfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   177: bipush 50
    //   179: if_icmple +9 -> 188
    //   182: aload_0
    //   183: bipush 50
    //   185: putfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   188: aload_0
    //   189: getfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   192: iconst_1
    //   193: if_icmpge +8 -> 201
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield 33	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Int	I
    //   201: aload_0
    //   202: aload_1
    //   203: iconst_2
    //   204: aaload
    //   205: putfield 31	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   208: aload_1
    //   209: iconst_3
    //   210: aaload
    //   211: ldc 109
    //   213: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   216: ifeq +8 -> 224
    //   219: aload_0
    //   220: iconst_1
    //   221: putfield 123	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Boolean	Z
    //   224: aload_0
    //   225: aload_1
    //   226: iconst_4
    //   227: aaload
    //   228: invokestatic 129	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   231: invokevirtual 133	java/lang/Float:floatValue	()F
    //   234: putfield 135	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   237: aload_0
    //   238: getfield 135	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   241: fconst_1
    //   242: fcmpl
    //   243: ifle +8 -> 251
    //   246: aload_0
    //   247: fconst_1
    //   248: putfield 135	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   251: ldc 109
    //   253: aload_1
    //   254: iconst_5
    //   255: aaload
    //   256: invokevirtual 121	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   259: ifeq +61 -> 320
    //   262: aload_0
    //   263: iconst_1
    //   264: putfield 39	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   267: aload_0
    //   268: aload_1
    //   269: bipush 6
    //   271: aaload
    //   272: invokestatic 139	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   275: putfield 42	com/tencent/mobileqq/app/MemoryConfigs:jdField_b_of_type_Float	F
    //   278: return
    //   279: astore_1
    //   280: aload_0
    //   281: ldc 40
    //   283: putfield 42	com/tencent/mobileqq/app/MemoryConfigs:jdField_b_of_type_Float	F
    //   286: return
    //   287: astore_1
    //   288: invokestatic 66	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   291: ifeq -191 -> 100
    //   294: ldc 12
    //   296: iconst_2
    //   297: ldc -115
    //   299: aload_1
    //   300: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   303: return
    //   304: aload_2
    //   305: iconst_0
    //   306: aaload
    //   307: astore_1
    //   308: goto -184 -> 124
    //   311: astore_2
    //   312: aload_0
    //   313: fconst_0
    //   314: putfield 135	com/tencent/mobileqq/app/MemoryConfigs:jdField_a_of_type_Float	F
    //   317: goto -66 -> 251
    //   320: aload_0
    //   321: iconst_0
    //   322: putfield 39	com/tencent/mobileqq/app/MemoryConfigs:c	Z
    //   325: goto -58 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	this	MemoryConfigs
    //   41	228	1	localObject1	Object
    //   279	1	1	localException1	Exception
    //   287	13	1	localException2	Exception
    //   307	1	1	localObject2	Object
    //   52	253	2	localObject3	Object
    //   311	1	2	localException3	Exception
    //   7	1	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   267	278	279	java/lang/Exception
    //   124	188	287	java/lang/Exception
    //   188	201	287	java/lang/Exception
    //   201	224	287	java/lang/Exception
    //   251	267	287	java/lang/Exception
    //   280	286	287	java/lang/Exception
    //   312	317	287	java/lang/Exception
    //   320	325	287	java/lang/Exception
    //   224	251	311	java/lang/Exception
  }
  
  public static MemoryConfigs a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs = new MemoryConfigs();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryConfigs;
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\MemoryConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */