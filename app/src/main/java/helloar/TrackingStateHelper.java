/*
 * Copyright 2019 Google Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package helloar;

import com.google.ar.core.Camera;
import com.google.ar.core.TrackingFailureReason;

/** Gets human readibly tracking failure reasons and suggested actions. */
final class TrackingStateHelper {
  private static final String INSUFFICIENT_FEATURES_MESSAGE =
      "Can't find anything. Aim device at a surface with more texture or color.";
  private static final String EXCESSIVE_MOTION_MESSAGE = "Moving too fast. Slow down.";
  private static final String INSUFFICIENT_LIGHT_MESSAGE =
      "Too dark. Try moving to a well-lit area.";
  private static final String BAD_STATE_MESSAGE =
      "Tracking lost due to bad internal state. Please try restarting the AR experience.";

  public static String getTrackingFailureReasonString(Camera camera) {
    TrackingFailureReason reason = camera.getTrackingFailureReason();
    switch (reason) {
      case NONE:
        return "";
      case BAD_STATE:
        return BAD_STATE_MESSAGE;
      case INSUFFICIENT_LIGHT:
        return INSUFFICIENT_LIGHT_MESSAGE;
      case EXCESSIVE_MOTION:
        return EXCESSIVE_MOTION_MESSAGE;
      case INSUFFICIENT_FEATURES:
        return INSUFFICIENT_FEATURES_MESSAGE;
    }
    return "Unknown tracking failure reason: " + reason;
  }
}
