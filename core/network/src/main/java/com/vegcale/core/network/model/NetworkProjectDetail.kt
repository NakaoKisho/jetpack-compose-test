package com.vegcale.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkProjectDetail(
    val id: Int,

    val title: String,

    @SerialName("published_at")
    val publishedAt: String,

    @SerialName("support_count")
    val supportCount: Int,

    @SerialName("page_view")
    val pageView: Int,

    @SerialName("candidate_count")
    val candidateCount: Int,

    @SerialName("application_qualification")
    val applicationQualification: Int,

    val location: String,

    @SerialName("location_suffix")
    val locationSuffix: String,

    val latitude: Float,

    val longitude: Float,

    val description: String,

    @SerialName("looking_for")
    val lookingFor: String,

    val image: NetworkProjectDetailImage,

    @SerialName("use_webview")
    val useWebView: Boolean,

    @SerialName("what_description")
    val whatDescription: String,

    @SerialName("what_images")
    val whatImages: List<NetworkProjectDetailWhatImage>,

    @SerialName("why_description")
    val whyDescription: String,

    @SerialName("why_images")
    val whyImages: List<NetworkProjectDetailWhyImage>,

    @SerialName("how_description")
    val howDescription: String,

    @SerialName("how_images")
    val howImages: List<NetworkProjectDetailHowImage>,

    val company: NetworkProjectDetailCompany,

    @SerialName("staffings_count")
    val staffCount: Int,

    @SerialName("staffings")
    val staff: List<NetworkProjectDetailStaff>,

    val supporters: List<NetworkProjectDetailSupporters>,

    @SerialName("category_tags")
    val categoryTags: List<String>,

    @SerialName("mutual_friends_count")
    val mutualFriendsCount: Int? = 0,

    @SerialName("mutual_friends")
    val mutualFriends: List<String>? = null,

    @SerialName("can_support")
    val canSupport: Boolean? = false,

    @SerialName("can_apply")
    val canApply: Boolean? = false,

    val applied: Boolean? = false,

    val supported: Boolean? = false,

    @SerialName("can_bookmark")
    val canBookmark: Boolean? = false,

    val scouted: Boolean? = false,

    val published: Boolean,

    @SerialName("hiring_types")
    val hiringTypes: List<String>,

    val tags: List<String>,

    @SerialName("video_available")
    val videoAvailable: Boolean,
)

@Serializable
data class NetworkProjectDetailImage(
    @SerialName("i_320_131")
    val i320131: String,

    @SerialName("i_320_131_x2")
    val i320131x2: String,

    @SerialName("max_1136")
    val max1136: String,

    @SerialName("i_105_130")
    val i105130: String,

    @SerialName("i_105_130_x2")
    val i105130x2: String,

    @SerialName("i_255_70")
    val i25570: String,

    @SerialName("i_255_70_x2")
    val i25570x2: String,

    @SerialName("i_50_50")
    val i5050: String,

    @SerialName("i_50_50_x2")
    val i5050x2: String,

    @SerialName("i_304_124")
    val i304124: String,

    @SerialName("i_304_124_x2")
    val i304124x2: String,

    val caption: String?,

    val original: String,
)

@Serializable
data class NetworkProjectDetailWhatImage(
    @SerialName("i_280_175")
    val i280175: String,

    @SerialName("i_280_175_x2")
    val i280175x2: String,

    @SerialName("max_1136")
    val max1136: String,

    val caption: String?,

    val original: String,
)

@Serializable
data class NetworkProjectDetailWhyImage(
    @SerialName("i_280_175")
    val i280175: String,

    @SerialName("i_280_175_x2")
    val i280175x2: String,

    @SerialName("max_1136")
    val max1136: String,

    val caption: String,

    val original: String,
)

@Serializable
data class NetworkProjectDetailHowImage(
    @SerialName("i_280_175")
    val i280175: String,

    @SerialName("i_280_175_x2")
    val i280175x2: String,

    @SerialName("max_1136")
    val max1136: String,

    val caption: String,

    val original: String,
)

@Serializable
data class NetworkProjectDetailCompany(
    val id: Int,

    val name: String,

    val founder: String,

    @SerialName("founded_on")
    val foundedOn: String,

    @SerialName("payroll_number")
    val payrollNumber: Int,

    @SerialName("address_prefix")
    val addressPrefix: String,

    @SerialName("address_suffix")
    val addressSuffix: String,

    val latitude: Float,

    val longitude: Float,

    val url: String,

    val tags: List<String>,

    val avatar: NetworkProjectDetailCompanyAvatar,

    @SerialName("industories")
    val industries: List<String>,
)

@Serializable
data class NetworkProjectDetailCompanyAvatar(
    val original: String,

    @SerialName("s_20")
    val s20: String,

    @SerialName("s_30")
    val s30: String,

    @SerialName("s_40")
    val s40: String,

    @SerialName("s_50")
    val s50: String,

    @SerialName("s_60")
    val s60: String,

    @SerialName("s_100")
    val s100: String,
)

@Serializable
data class NetworkProjectDetailStaff(
    @SerialName("user_id")
    val userId: Long,

    val description: String,

    @SerialName("is_leader")
    val isLeader: Boolean,

    val name: String,

    @SerialName("facebook_uid")
    val facebookUid: String?,

    val position: String,

    val avatar: NetworkProjectDetailStaffAvatar,
)

@Serializable
data class NetworkProjectDetailSupporters(
    @SerialName("supporter_id")
    val supporterId: Long,

    @SerialName("facebook_uid")
    val facebookUid: String?,

    val name: String,
)

@Serializable
data class NetworkProjectDetailStaffAvatar(
    @SerialName("s_20")
    val s20: String,

    @SerialName("s_30")
    val s30: String,

    @SerialName("s_32")
    val s32: String,

    @SerialName("s_35")
    val s35: String,

    @SerialName("s_40")
    val s40: String,

    @SerialName("s_50")
    val s50: String,

    @SerialName("s_60")
    val s60: String,

    @SerialName("s_64")
    val s64: String,

    @SerialName("s_70")
    val s70: String,

    @SerialName("s_80")
    val s80: String,

    @SerialName("s_100")
    val s100: String,

    @SerialName("s_120")
    val s120: String,

    @SerialName("s_140")
    val s140: String,

    val thumb: String,

    val medium: String,

    val square: String,

    val large: String,

    @SerialName("max_130")
    val max130: String,

    @SerialName("max_300")
    val max300: String,

    @SerialName("max_1440")
    val max1440: String,

    @SerialName("w_470")
    val w470: String,

    @SerialName("h_400")
    val h400: String,

    @SerialName("i_980_280")
    val i980280: String,

    val original: String?,
)
