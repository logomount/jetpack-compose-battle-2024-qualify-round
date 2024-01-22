package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify3Screen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "John Doe",
                        style = MaterialTheme.typography.titleLarge.copy(letterSpacing = 0.5.sp)
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_3_back),
                        contentDescription = "Back"
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                        contentDescription = "Copy"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                        contentDescription = "Calendar"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                        contentDescription = "Menu"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        val photos = remember {
            mutableStateListOf(
                R.drawable.img_qualify_3_photo_1,
                R.drawable.img_qualify_3_photo_2,
                R.drawable.img_qualify_3_photo_3
            )
        }
        val tags = remember { mutableStateListOf("Tag 1", "Tag 2", "Tag 3", "Tag 4") }
        val cards = remember {
            mutableStateListOf(
                "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
                "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
                "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
                "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget."
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White),
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 16.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(key = 0) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(items = photos, key = { photo -> photo }) { photo ->
                        Image(
                            modifier = Modifier
                                .size(
                                    width = 160.dp,
                                    height = 320.dp
                                )
                                .border(
                                    width = 2.dp,
                                    color = if (photos.first() == photo)
                                        MaterialTheme.colorScheme.primary
                                    else MaterialTheme.colorScheme.primaryContainer,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .clip(RoundedCornerShape(16.dp)),
                            painter = painterResource(id = photo),
                            contentDescription = "Profile photo"
                        )
                    }
                }
            }
            item(key = 1) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(7.45.dp)
                ) {
                    items(items = tags, key = { tag -> tag }) { tag ->
                        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {
                            SuggestionChip(
                                onClick = {
                                    // TODO: Do something
                                },
                                label = {
                                    Text(
                                        text = tag,
                                        style = MaterialTheme.typography.labelLarge.copy(
                                            letterSpacing = 0.5.sp
                                        )
                                    )
                                },
                                enabled = tags.first() == tag,
                                colors = SuggestionChipDefaults.suggestionChipColors(
                                    containerColor = Color.White,
                                    labelColor = MaterialTheme.colorScheme.primary,
                                    iconContentColor = MaterialTheme.colorScheme.primary,
                                    disabledContainerColor = Color.White,
                                    disabledLabelColor = MaterialTheme.colorScheme.outline,
                                    disabledIconContentColor = MaterialTheme.colorScheme.outline
                                ),
                                border = SuggestionChipDefaults.suggestionChipBorder(
                                    borderColor = MaterialTheme.colorScheme.primary,
                                    disabledBorderColor = MaterialTheme.colorScheme.outline,
                                    borderWidth = 1.dp
                                ),
                                shape = RoundedCornerShape(8.dp)
                            )
                        }
                    }
                }
            }
            items(items = cards, key = { card -> card }) { card ->
                Card(
                    modifier = Modifier
                        .height(96.dp)
                        .padding(end = 16.dp)
                        .background(MaterialTheme.colorScheme.surface),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        disabledContainerColor = MaterialTheme.colorScheme.surface,
                        disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.img_qualify_3_sender),
                            contentDescription = "Onboarding photo"
                        )
                        Column {
                            Text(
                                text = "Lorem Ipsum",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    letterSpacing = 0.5.sp
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = card,
                                style = MaterialTheme.typography.bodyMedium.copy(letterSpacing = 0.5.sp),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion