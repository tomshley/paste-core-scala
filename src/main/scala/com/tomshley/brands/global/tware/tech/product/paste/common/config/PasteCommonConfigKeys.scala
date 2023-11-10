package com.tomshley.brands.global.tware.tech.product.paste.common.config

protected[paste] enum PasteCommonConfigKeys(configBlockKey: PasteCommonConfigBlockKey) {
  case DEFAULT_VERSION extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "defaultVersion", Some(1.0)))
  case CONTENT_TYPE_PATHS extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "contentTypePaths", Some(Seq())))
  case COMPILE_MODE_ENABLED extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "compileModeEnabled", Some(false)))
  case BUILD_AREA extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "buildArea"))
  case BUILD_PREFIX extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "buildPrefix", Some("_build")))
  case ROOT_URI extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "rootURI", Some("/path")))
  case VERSIONING_ENABLED extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "versioningEnabled", Some(true)))
  case APP_ROOT extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "appRoot", Some("/..")))
  case EXCLUDED_DIRS extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "excludedDirs", Some(Seq())))
  case NETWORK_REQUEST_THRESHOLD extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "requestThreshold", Some(4)))
  case HTTP_LFU_CACHE_NAME extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheName", Some("paste-http-cache")))
  case HTTP_LFU_CACHE_INITIAL_SIZE extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheInitialSize", Some(0)))
  case HTTP_LFU_CACHE_MAX_CAPACITY extends PasteCommonConfigKeys(PasteCommonConfigBlockKey(PasteCommonConfigBlocks.PASTE, "httpLFUCacheMaxCapacity", Some(1024)))
  def toValue: String = configBlockKey.toString
}
