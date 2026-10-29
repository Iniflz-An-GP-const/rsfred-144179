package nelson.rsfred.hubapp.ui.composable.screen.topic_selection.card

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import nelson.rsfred.hubapp.R
import nelson.rsfred.hubapp.ui.composable.screen.shared.modifier.press.pressFeedback
import nelson.rsfred.hubapp.ui.composable.screen.topic_selection.card.TopicCardDefaults
import nelson.rsfred.hubapp.ui.composable.screen.topic_selection.card.TopicCardItem
import nelson.rsfred.hubapp.ui.theme.LocalDimens
import nelson.rsfred.hubapp.ui.theme.cardBorderStroke

private val BadgeSize = 24.dp
private val BadgeIconSize = 16.dp
private val BadgeBorderWidth = 1.5.dp

/** Card chrome never changes — selection is shown only by a trailing checkmark badge. */
@Composable
fun TopicCard(
    item: TopicCardItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current
    val shape = TopicCardDefaults.shape
    val interactionSource = remember { MutableInteractionSource() }
    val border = cardBorderStroke()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .pressFeedback(interactionSource)
            .clip(shape)
            .background(color = MaterialTheme.colorScheme.surfaceContainer, shape = shape)
            .let { base -> if (border != null) base.border(border, shape) else base }
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
            )
            .padding(TopicCardDefaults.padding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(dimens.itemSpacing),
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(TopicCardDefaults.titleSpacing),
        ) {
            Text(
                text = item.title,
                style = TopicCardDefaults.titleStyle(),
                color = MaterialTheme.colorScheme.onSurface,
                minLines = TopicCardDefaults.TitleLines,
                maxLines = TopicCardDefaults.TitleLines,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = pluralStringResource(R.plurals.topic_question_count, item.questionCount, item.questionCount),
                style = TopicCardDefaults.countStyle(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        if (item.isSelected) {
            Box(
                modifier = Modifier
                    .size(BadgeSize)
                    .background(color = MaterialTheme.colorScheme.primary, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(BadgeIconSize),
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .size(BadgeSize)
                    .border(width = BadgeBorderWidth, color = MaterialTheme.colorScheme.outline, shape = CircleShape),
            )
        }
    }
}
