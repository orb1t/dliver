/**
 * Copyright (C) 2012 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingml.dliver.driver;

import java.util.Hashtable;

public enum DliverMode {
	EMGRawCh2 (28),
	RawGyroMode (29),
	Extracted(30),
	FullECG_EMGRawCh1(31),
	Raw(32),
	Test(33),
	RawAccelerometer(34);
	
	private final int code;
        
        public static DliverMode fromCode(int code) {
            switch(code) {
                case 28: return DliverMode.EMGRawCh2;
                case 29: return DliverMode.RawGyroMode;
                case 30: return DliverMode.Extracted;
                case 31: return DliverMode.FullECG_EMGRawCh1;
                case 32: return DliverMode.Raw;
                case 33: return DliverMode.Test;
                case 34: return DliverMode.RawAccelerometer;
                default: return null;
            }
        }
	
	private DliverMode(int c) {
		this.code = c;
	}
	
	public int getCode() {
		return this.code;
	}
}
