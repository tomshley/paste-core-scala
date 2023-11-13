package com.tomshley.brands.global.tware.tech.product.paste.common.config

protected[paste] enum PasteCommonConfigKeys(configBlockKey: PasteCommonConfigBlockKey) {
  case DEFAULT_VERSION extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "defaultVersion", Some(1.0)))
  case COMPILE_MODE_ENABLED extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "compileModeEnabled", Some(false)))
  case BUILD_DIR_NAME extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "buildDirName", Some(".paste_build")))
  case PASTE_ROOT extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "rootPath", Some("/paste")))
  case VERSIONING_ENABLED extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "versioningEnabled", Some(true)))
  case EXCLUDED_DIRS extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "excludedDirs", Some(Seq())))
  case NETWORK_REQUEST_THRESHOLD extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "requestThreshold", Some(4)))
  case HTTP_LFU_CACHE_NAME extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheName", Some("paste-http-cache")))
  case HTTP_LFU_CACHE_INITIAL_SIZE extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheInitialSize", Some(0)))
  case HTTP_LFU_CACHE_MAX_CAPACITY extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheMaxCapacity", Some(1024)))

  def toValue: String = configBlockKey.toString
}
