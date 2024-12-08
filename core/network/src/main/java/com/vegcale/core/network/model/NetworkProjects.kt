package com.vegcale.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkProjects(
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

    val location: String,

    @SerialName("location_suffix")
    val locationSuffix: String,

    val description: String,

    @SerialName("looking_for")
    val lookingFor: String,

    val image: NetworkProjectsImage,

    @SerialName("use_webview")
    val useWebView: Boolean,

    val company: NetworkProjectsCompany,

    @SerialName("staffings_count")
    val staffCount: Int,

    @SerialName("staffings")
    val staff: List<NetworkProjectsStaff>,

    val leader: NetworkProjectsLeader,

    @SerialName("video_available")
    val videoAvailable: Boolean,

    @SerialName("category_images")
    val categoryImages: List<String>,

    val tags: List<String>,

    @SerialName("category_message")
    val categoryMessage: String,

    @SerialName("can_support")
    val canSupport: Boolean,

    val supported: Boolean,

    @SerialName("can_apply")
    val canApply: Boolean,

    val applied: Boolean,

    @SerialName("can_bookmark")
    val canBookmark: Boolean,
)

@Serializable
data class NetworkProjectsImage(
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
data class NetworkProjectsCompany(
    val id: Int,

    val name: String,

    val founder: String?,

    @SerialName("founded_on")
    val foundedOn: String?,

    @SerialName("payroll_number")
    val payrollNumber: Int?,

    @SerialName("address_prefix")
    val addressPrefix: String?,

    @SerialName("address_suffix")
    val addressSuffix: String?,

    val latitude: Float?,

    val longitude: Float?,

    val url: String,

    @SerialName("font_color_code")
    val fontColorCode: String,

    val avatar: NetworkProjectsCompanyAvatar,
)

@Serializable
data class NetworkProjectsCompanyAvatar(
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
data class NetworkProjectsStaff(
    @SerialName("user_id")
    val userId: Int,

    @SerialName("is_leader")
    val isLeader: Boolean,

    val name: String,

    @SerialName("facebook_uid")
    val facebookUid: Int?,

    val description: String,
)

@Serializable
data class NetworkProjectsLeader(
    @SerialName("name_ja")
    val nameJa: String?,

    @SerialName("name_en")
    val nameEn: String?,

    @SerialName("facebook_uid")
    val facebookUid: String?,

)
