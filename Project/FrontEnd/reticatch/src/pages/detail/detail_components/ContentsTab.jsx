function ContentsTab({children, onClick}) {
    return (
        <li>
            <button className="" onClick={onClick}>{children}</button>
        </li>
    );
}

export default ContentsTab;