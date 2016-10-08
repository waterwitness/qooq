package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version
  implements Comparable<Version>, Serializable
{
  private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
  private static final long serialVersionUID = 1L;
  protected final String _artifactId;
  protected final String _groupId;
  protected final int _majorVersion;
  protected final int _minorVersion;
  protected final int _patchLevel;
  protected final String _snapshotInfo;
  
  @Deprecated
  public Version(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this(paramInt1, paramInt2, paramInt3, paramString, null, null);
  }
  
  public Version(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    this._majorVersion = paramInt1;
    this._minorVersion = paramInt2;
    this._patchLevel = paramInt3;
    this._snapshotInfo = paramString1;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    this._groupId = paramString1;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    this._artifactId = paramString1;
  }
  
  public static Version unknownVersion()
  {
    return UNKNOWN_VERSION;
  }
  
  public int compareTo(Version paramVersion)
  {
    int i;
    if (paramVersion == this) {
      i = 0;
    }
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            j = this._groupId.compareTo(paramVersion._groupId);
            i = j;
          } while (j != 0);
          j = this._artifactId.compareTo(paramVersion._artifactId);
          i = j;
        } while (j != 0);
        j = this._majorVersion - paramVersion._majorVersion;
        i = j;
      } while (j != 0);
      j = this._minorVersion - paramVersion._minorVersion;
      i = j;
    } while (j != 0);
    return this._patchLevel - paramVersion._patchLevel;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (paramObject.getClass() != getClass()) {
        return false;
      }
      paramObject = (Version)paramObject;
    } while ((((Version)paramObject)._majorVersion == this._majorVersion) && (((Version)paramObject)._minorVersion == this._minorVersion) && (((Version)paramObject)._patchLevel == this._patchLevel) && (((Version)paramObject)._artifactId.equals(this._artifactId)) && (((Version)paramObject)._groupId.equals(this._groupId)));
    return false;
  }
  
  public String getArtifactId()
  {
    return this._artifactId;
  }
  
  public String getGroupId()
  {
    return this._groupId;
  }
  
  public int getMajorVersion()
  {
    return this._majorVersion;
  }
  
  public int getMinorVersion()
  {
    return this._minorVersion;
  }
  
  public int getPatchLevel()
  {
    return this._patchLevel;
  }
  
  public int hashCode()
  {
    return this._artifactId.hashCode() ^ this._groupId.hashCode() + this._majorVersion - this._minorVersion + this._patchLevel;
  }
  
  public boolean isSnapshot()
  {
    return (this._snapshotInfo != null) && (this._snapshotInfo.length() > 0);
  }
  
  public boolean isUknownVersion()
  {
    return this == UNKNOWN_VERSION;
  }
  
  public String toFullString()
  {
    return this._groupId + '/' + this._artifactId + '/' + toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this._majorVersion).append('.');
    localStringBuilder.append(this._minorVersion).append('.');
    localStringBuilder.append(this._patchLevel);
    if (isSnapshot()) {
      localStringBuilder.append('-').append(this._snapshotInfo);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\fasterxml\jackson\core\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */