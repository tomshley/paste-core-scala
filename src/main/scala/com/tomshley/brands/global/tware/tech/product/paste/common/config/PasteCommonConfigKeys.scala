package com.tomshley.brands.global.tware.tech.product.paste.common.config

protected[paste] enum PasteCommonConfigKeys[T](configBlockKey: PasteCommonConfigBlockKey[T]) {
  case DEFAULT_VERSION extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE, "defaultVersion", "1.0"))
  case COMPILE_MODE_ENABLED extends PasteCommonConfigKeys[Boolean](PasteCommonConfigBlockKey[Boolean](PasteCommonConfigBlocks.PASTE, "compileModeEnabled", false))
  case BUILD_DIR_NAME extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE, "buildDirName", ".paste_build"))
  case CONTENT_DIR_SCRIPTS extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE_DIRECTORY_MAP, "scripts", "paste/scripts"))
  case CONTENT_DIR_STYLES extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE_DIRECTORY_MAP, "scripts", "paste/styles"))
  case CONTENT_DIR_IMG extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE_DIRECTORY_MAP, "scripts", "paste/images"))
  case PASTE_ROOT extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE, "rootPath", "/paste"))
  case VERSIONING_ENABLED extends PasteCommonConfigKeys[Boolean](PasteCommonConfigBlockKey[Boolean](PasteCommonConfigBlocks.PASTE, "versioningEnabled", true))
  case EXCLUDED_DIRS extends PasteCommonConfigKeys[Seq[String]](PasteCommonConfigBlockKey[Seq[String]](PasteCommonConfigBlocks.PASTE, "excludedDirs", Seq()))
  case NETWORK_REQUEST_THRESHOLD extends PasteCommonConfigKeys[Int](PasteCommonConfigBlockKey[Int](PasteCommonConfigBlocks.PASTE, "requestThreshold", 4))
  case IO_ACTOR_SYSTEM extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE, "ioActorSystemName", "paste-io-system"))
  case HTTP_LFU_CACHE_NAME extends PasteCommonConfigKeys[String](PasteCommonConfigBlockKey[String](PasteCommonConfigBlocks.PASTE, "httpLFUCacheName", "paste-http-cache"))
  case HTTP_LFU_CACHE_INITIAL_SIZE extends PasteCommonConfigKeys[Int](PasteCommonConfigBlockKey[Int](PasteCommonConfigBlocks.PASTE, "httpLFUCacheInitialSize", 0))
  case HTTP_LFU_CACHE_MAX_CAPACITY extends PasteCommonConfigKeys[Int](PasteCommonConfigBlockKey[Int](PasteCommonConfigBlocks.PASTE, "httpLFUCacheMaxCapacity", 1024))

  def toValue: T = configBlockKey.toValue

  def toValueString: String = configBlockKey.toString
}
