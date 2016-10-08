package com.tencent.kingkong;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubPatches
{
  private static final String c = "SubPatches";
  private static final String d = "subpatches";
  private static final String e = "subpatch_count";
  private static final String f = "fingerprint_count";
  private static final String g = "fingerprint_definition";
  private static final String h = "lib_name";
  private static final String i = "func_name";
  private static final String j = "hookpoint_lib_name";
  private static final String k = "hookpoint_func_name";
  private static final String l = "parameter_definition";
  private static final String m = "param_count";
  private static final String n = "param_index";
  private static final String o = "param_type";
  private static final String p = "param_value1";
  private static final String q = "param_value2";
  public int a;
  public String a;
  public ArrayList a;
  public int b;
  public String b;
  public ArrayList b;
  public int c;
  public ArrayList c;
  public ArrayList d;
  
  public SubPatches()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.d = new ArrayList();
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: new 87	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_2
    //   10: new 90	java/io/BufferedReader
    //   13: dup
    //   14: new 92	java/io/InputStreamReader
    //   17: dup
    //   18: new 94	java/io/FileInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: invokespecial 100	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: sipush 8192
    //   32: invokespecial 103	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   35: astore_1
    //   36: aload_1
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: ifnull +34 -> 78
    //   47: aload_1
    //   48: astore_0
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: goto -19 -> 36
    //   58: astore_2
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 117	java/io/BufferedReader:close	()V
    //   73: aload_3
    //   74: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: areturn
    //   78: aload_1
    //   79: ifnull -6 -> 73
    //   82: aload_1
    //   83: invokevirtual 117	java/io/BufferedReader:close	()V
    //   86: goto -13 -> 73
    //   89: astore_0
    //   90: goto -17 -> 73
    //   93: astore_0
    //   94: aload_2
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +7 -> 104
    //   100: aload_1
    //   101: invokevirtual 117	java/io/BufferedReader:close	()V
    //   104: aload_0
    //   105: athrow
    //   106: astore_0
    //   107: goto -34 -> 73
    //   110: astore_1
    //   111: goto -7 -> 104
    //   114: astore_2
    //   115: aload_0
    //   116: astore_1
    //   117: aload_2
    //   118: astore_0
    //   119: goto -23 -> 96
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -66 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   35	66	1	localObject1	Object
    //   110	1	1	localIOException1	java.io.IOException
    //   116	9	1	str1	String
    //   9	42	2	str2	String
    //   58	37	2	localIOException2	java.io.IOException
    //   114	4	2	localObject2	Object
    //   122	1	2	localIOException3	java.io.IOException
    //   7	67	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	43	58	java/io/IOException
    //   49	55	58	java/io/IOException
    //   82	86	89	java/io/IOException
    //   10	36	93	finally
    //   69	73	106	java/io/IOException
    //   100	104	110	java/io/IOException
    //   38	43	114	finally
    //   49	55	114	finally
    //   61	65	114	finally
    //   10	36	122	java/io/IOException
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    paramString = a(paramString);
    for (;;)
    {
      Object localObject1;
      int i1;
      Object localObject2;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_b_of_type_Int = paramString.getInt("fingerprint_count");
        localObject1 = paramString.getJSONArray("fingerprint_definition");
        if (((JSONArray)localObject1).length() == this.jdField_b_of_type_Int) {
          break label566;
        }
        Common.Log.a("SubPatches", "Fingerprint count mismatch!");
        return false;
      }
      catch (JSONException paramString)
      {
        Object localObject3;
        Common.Log.a("SubPatches", "Parse sub patches failed : " + paramString);
        return false;
      }
      if (i1 < this.jdField_b_of_type_Int)
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(i1);
        localObject2 = ((JSONObject)localObject3).getString("lib_name").trim();
        localObject3 = ((JSONObject)localObject3).getString("func_name").trim();
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
        this.jdField_c_of_type_JavaUtilArrayList.add(localObject3);
        Common.Log.a("SubPatches", "--> Fingerprint Library Name : " + (String)localObject2 + " ; Function Name : " + (String)localObject3);
        i1 += 1;
      }
      else
      {
        this.jdField_c_of_type_Int = paramString.getInt("param_count");
        localObject1 = paramString.getJSONArray("parameter_definition");
        if (this.jdField_c_of_type_Int != ((JSONArray)localObject1).length())
        {
          Common.Log.a("SubPatches", "Parameter count mismatch :" + this.jdField_c_of_type_Int + ", " + ((JSONArray)localObject1).length());
          return false;
        }
        i1 = 0;
        while (i1 < this.jdField_c_of_type_Int)
        {
          localObject2 = new SubPatches.ParameterDef(this);
          bool1 = bool2;
          if (!((SubPatches.ParameterDef)localObject2).a(((JSONArray)localObject1).getJSONObject(i1))) {
            break label563;
          }
          if (((SubPatches.ParameterDef)localObject2).jdField_a_of_type_Int != i1)
          {
            Common.Log.a("SubPatches", "Parameter index error!");
            return false;
          }
          Common.Log.a("SubPatches", "--> Parameter definition : " + localObject2);
          this.d.add(localObject2);
          i1 += 1;
        }
        this.jdField_b_of_type_JavaLangString = paramString.getString("hookpoint_func_name").trim();
        this.jdField_a_of_type_JavaLangString = paramString.getString("hookpoint_lib_name").trim();
        Common.Log.a("SubPatches", "--> Hookpoint library Name : " + this.jdField_a_of_type_JavaLangString);
        Common.Log.a("SubPatches", "--> Hookpoint function Name : " + this.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_Int = paramString.getInt("subpatch_count");
        paramString = paramString.getJSONArray("subpatches");
        i1 = 0;
        while (i1 < paramString.length())
        {
          Common.Log.a("SubPatches", "Parseing sub patch " + i1);
          localObject1 = new SubPatch();
          if (((SubPatch)localObject1).a(this, paramString.getJSONObject(i1)))
          {
            ((SubPatch)localObject1).a();
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            i1 += 1;
          }
          else
          {
            Common.Log.a("SubPatches", "Parse sub patch failed, give up");
            return false;
          }
        }
        if (this.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          Common.Log.a("SubPatches", "Sub patch count mismatch, give up");
          return false;
        }
        boolean bool1 = true;
        label563:
        return bool1;
        label566:
        i1 = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\SubPatches.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */