package com.tencent.bitapp.module;

import com.tencent.bitapp.pre.PreConst;
import java.io.File;

public class Module
{
  private String mCssFile = null;
  private String mFolder = null;
  private String mHtmFile = null;
  private String mJsFile = null;
  private String mJsxFile = null;
  private String mKey = null;
  private String mListFile = null;
  
  public Module(String paramString)
  {
    this.mKey = paramString;
    this.mFolder = (PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString);
    paramString = this.mFolder + File.separator + paramString;
    this.mListFile = (paramString + ".list");
    this.mHtmFile = (paramString + ".html");
    this.mCssFile = (paramString + ".css");
    this.mJsFile = (paramString + ".js");
    this.mJsxFile = (paramString + ".jsx");
  }
  
  public static String getCssFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + File.separator + paramString + ".css";
  }
  
  public static String getFolder(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString;
  }
  
  public static String getHtmFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + File.separator + paramString + ".html";
  }
  
  public static String getJsFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + File.separator + paramString + ".js";
  }
  
  public static String getJsxFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + File.separator + paramString + ".jsx";
  }
  
  public static String getListFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + File.separator + paramString + ".list";
  }
  
  public static String getZipFile(String paramString)
  {
    return PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER + File.separator + paramString + ".zip";
  }
  
  public String getCssFile()
  {
    return this.mCssFile;
  }
  
  public String getFolder()
  {
    return this.mFolder;
  }
  
  public String getHtmFile()
  {
    return this.mHtmFile;
  }
  
  public String getJsFile()
  {
    return this.mJsFile;
  }
  
  public String getJsxFile()
  {
    return this.mJsxFile;
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  public String getListFile()
  {
    return this.mListFile;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\module\Module.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */