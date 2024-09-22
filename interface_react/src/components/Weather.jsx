import sharedStyles from "./CSS/shared.module.css";

export default function Weather() {
    return (
        <>
            <div className={sharedStyles.banner}>Weather</div>
            <div className={sharedStyles.container}>
                Weather page
            </div>

        </>
    )
}