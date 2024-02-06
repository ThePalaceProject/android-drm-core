package org.thepalaceproject.drm.core

import org.librarysimplified.http.api.LSHTTPClientType

interface AxisNowServiceFactoryType {

  fun create(httpClient: LSHTTPClientType): AxisNowServiceType
}
