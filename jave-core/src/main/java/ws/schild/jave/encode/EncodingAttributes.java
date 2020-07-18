/*
 * JAVE - A Java Audio/Video Encoder (based on FFMPEG)
 * 
 * Copyright (C) 2008-2009 Carlo Pelliccia (www.sauronsoftware.it)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ws.schild.jave.encode;

import java.io.Serializable;
import java.util.Optional;

import ws.schild.jave.Encoder;

/**
 * Attributes controlling the encoding process.
 *
 * @author Carlo Pelliccia
 */
public class EncodingAttributes implements Serializable {

	private static final long serialVersionUID = 2473587816471032706L;

	/**
     * The format name for the encoded target multimedia file. Be sure this
     * format is supported (see {@link Encoder#getSupportedEncodingFormats()}.
     */
    private String format = null;

    /**
     * The start offset time (seconds). If null or not specified no start offset
     * will be applied.
     */
    private Float offset = null;

    /**
     * The duration (seconds) of the re-encoded stream. If null or not specified
     * the source stream, starting from the offset, will be completely
     * re-encoded in the target stream.
     */
    private Float duration = null;

    /**
     * The attributes for the encoding of the audio stream in the target
     * multimedia file. If null of not specified no audio stream will be
     * encoded. It cannot be null if also the video field is null.
     */
    private AudioAttributes audioAttributes = null;

    /**
     * The attributes for the encoding of the video stream in the target
     * multimedia file. If null of not specified no video stream will be
     * encoded. It cannot be null if also the audio field is null.
     */
    private VideoAttributes videoAttributes = null;

    /**
     * Should we try to copy over the meta data?
     */
    private boolean mapMetaData= false;
    
    /**
     * Maximum number of cores/cpus to use for conversion.<br/>
     * Not set means we use ffmpeg's default.
     */
    private Integer filterThreads;
    /**
     * Number of threads to use for decoding (if supported by codec)
     */
    private Integer decodingThreads = null;
    /**
     * Number of threads to use for encoding (if supported by codec)
     */
    private Integer encodingThreads = null;

    /**
    * Should the input be treated as a loop
    */
    private boolean loop = false;

    /**
     * Returns the format name for the encoded target multimedia file.
     *
     * @return The format name for the encoded target multimedia file.
     */
    public Optional<String> getFormat() {
        return Optional.ofNullable(format);
    }

    /**
     * Sets the format name for the encoded target multimedia file. Be sure this
     * format is supported (see {@link Encoder#getSupportedEncodingFormats()}.
     *
     * @param format The format name for the encoded target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setFormat(String format) {
        this.format = format;
        return this;
    }

    /**
     * Returns the start offset time (seconds).
     *
     * @return The start offset time (seconds).
     */
    public Optional<Float> getOffset() {
        return Optional.ofNullable(offset);
    }

    /**
     * Sets the start offset time (seconds). If null or not specified no start
     * offset will be applied.
     *
     * @param offset The start offset time (seconds).
     * @return this instance
     */
    public EncodingAttributes setOffset(Float offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Returns the duration (seconds) of the re-encoded stream.
     *
     * @return The duration (seconds) of the re-encoded stream.
     */
    public Optional<Float> getDuration() {
        return Optional.ofNullable(duration);
    }

    /**
     * Sets the duration (seconds) of the re-encoded stream. If null or not
     * specified the source stream, starting from the offset, will be completely
     * re-encoded in the target stream.
     *
     * @param duration The duration (seconds) of the re-encoded stream.
     * @return this instance
     */
    public EncodingAttributes setDuration(Float duration) {
        this.duration = duration;
        return this;
    }

    /*
     * Returns if the input is to be considered for looping.
     * @return if the input will be looped.
     */
    public boolean getLoop() {
	    return loop;
	}

    /**
     * Sets if the inputs will be looped or not.
     *
     * @param loop if the input should be looped.
     * @return this instance
     */
    public EncodingAttributes setLoop(boolean loop) {
	    this.loop = loop;
	    return this;
	}

    /**
     * Returns the attributes for the encoding of the audio stream in the target
     * multimedia file.
     *
     * @return The attributes for the encoding of the audio stream in the target
     * multimedia file.
     */
    public Optional<AudioAttributes> getAudioAttributes() {
        return Optional.ofNullable(audioAttributes);
    }

    /**
     * Sets the attributes for the encoding of the audio stream in the target
     * multimedia file. If null of not specified no audio stream will be
     * encoded. It cannot be null if also the video field is null.
     *
     * @param audioAttributes The attributes for the encoding of the audio
     * stream in the target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setAudioAttributes(AudioAttributes audioAttributes) {
        this.audioAttributes = audioAttributes;
        return this;
    }

    /**
     * Returns the attributes for the encoding of the video stream in the target
     * multimedia file.
     *
     * @return The attributes for the encoding of the video stream in the target
     * multimedia file.
     */
    public Optional<VideoAttributes> getVideoAttributes() {
        return Optional.ofNullable(videoAttributes);
    }

    /**
     * Sets the attributes for the encoding of the video stream in the target
     * multimedia file. If null of not specified no video stream will be
     * encoded. It cannot be null if also the audio field is null.
     *
     * @param videoAttributes The attributes for the encoding of the video
     * stream in the target multimedia file.
     * @return this instance
     */
    public EncodingAttributes setVideoAttributes(VideoAttributes videoAttributes) {
        this.videoAttributes = videoAttributes;
        return this;
    }

    @Override
    public String toString() {
        return getClass().getName() + "(format=" + format + ", offset="
                + offset + ", duration=" + duration + ",loop=" + loop + ", audioAttributes="
                + audioAttributes + ", videoAttributes=" + videoAttributes
                + ")";
    }

    /**
     * @return the mapMetaData
     */
    public boolean isMapMetaData() {
        return mapMetaData;
    }

    /**
     * Copy over meta data from original file to new output if possible
     * 
     * @param mapMetaData the mapMetaData to set
     * @return this instance
     */
    public EncodingAttributes setMapMetaData(boolean mapMetaData) {
        this.mapMetaData = mapMetaData;
        return this;
    }

    /**
     * @return Maximum number of cores/cpus to use for filtering
     * -1 means use default of ffmpeg
     * 
     */
    public Optional<Integer> getFilterThreads() {
        return Optional.ofNullable(filterThreads);
    }

    /**
     * ffmpeg uses multiple cores for filtering
     * 
     * @param filterThreads Maximum number of cores/cpus to use
     * -1 means use default of ffmpeg
     * @return this instance
     */
    public EncodingAttributes setFilterThreads(int filterThreads) {
        this.filterThreads = filterThreads;
        return this;
    }

    /**
     * Number of threads to use for decoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @return the decodingThreads
     */
    public Optional<Integer> getDecodingThreads() {
        return Optional.ofNullable(decodingThreads);
    }

    /**
     * Number of threads to use for decoding (if supported by codec)
     * -1 means use default of ffmpeg
     * @param decodingThreads the decodingThreads to set
     * @return this instance
     */
    public EncodingAttributes setDecodingThreads(int decodingThreads) {
        this.decodingThreads = decodingThreads;
        return this;
    }

    /**
     * Number of threads to use for encoding (if supported by codec)
     * No value (Optional.empty()) means use default of ffmpeg
     * @return the encodingThreads
     */
    public Optional<Integer> getEncodingThreads() {
        return Optional.ofNullable(encodingThreads);
    }

    /**
     * Number of threads to use for encoding (if supported by codec)
     * null means use default of ffmpeg
     * @param encodingThreads the encodingThreads to set
     * @return this instance
     */
    public EncodingAttributes setEncodingThreads(Integer encodingThreads) {
        this.encodingThreads = encodingThreads;
        return this;
    }

	public void validate() {
		if (audioAttributes == null && videoAttributes == null) {
            throw new IllegalArgumentException("Both audio and video attributes are null");
        }
	}
    
}
